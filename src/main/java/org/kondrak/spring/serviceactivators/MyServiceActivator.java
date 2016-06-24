package org.kondrak.spring.serviceactivators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.jdbc.JdbcMessageHandler;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by kondrak on 6/23/2016.
 */
@Component
public class MyServiceActivator {

    @Autowired
    DataSource dataSource;

    @ServiceActivator(inputChannel = "outputChannel")
    public MessageHandler activate(String payload) {
        JdbcMessageHandler jdbcMessageHandler = new JdbcMessageHandler(dataSource,
                "INSERT INTO USERS (ID, NAME, EMAIL) VALUES ((SELECT MAX(ID) FROM USERS) + 1, ?, ?)");
        jdbcMessageHandler.setPreparedStatementSetter((ps, m) -> {
            ps.setString(1, payload);
            ps.setString(2, payload + "@gmail.com");
        });

        System.out.println("IN SERVICE ACTIVATOR : " + payload);
        return jdbcMessageHandler;
    }
}
