package org.kondrak.spring.receivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Payloads;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 6/24/2016.
 */
@Service
public class JdbcWriterService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ServiceActivator(inputChannel = "jdbcChannel")
    public void activate(String payload) {
        System.out.println("IN JDBC SERVICE: " + payload);
        jdbcTemplate.execute("INSERT INTO USER(ID, USER, EMAIL) VALUES (" +
                "(SELECT MAX(ID) + 1 FROM USER), '" + payload + "', '" + payload + "@gmail.com')");
        String s = jdbcTemplate.queryForObject("SELECT COUNT (*) FROM USER", String.class);
        System.out.println("Count on DB: " + s);
    }
}
