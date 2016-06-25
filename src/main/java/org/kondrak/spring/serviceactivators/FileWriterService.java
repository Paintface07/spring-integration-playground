package org.kondrak.spring.serviceactivators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.jdbc.JdbcMessageHandler;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.sql.DataSource;

/**
 * Created by kondrak on 6/23/2016.
 */
@Service
public class FileWriterService {

    @Autowired
    JmsTemplate jmsTemplate;

    @ServiceActivator(inputChannel = "outputChannel")
    public void activate(String payload) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(payload);
            }
        };

        System.out.println("IN FILE WRITER SERVICE : " + payload);
        jmsTemplate.send("file-writer-destination", messageCreator);
    }
}
