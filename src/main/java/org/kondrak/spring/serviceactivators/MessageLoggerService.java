package org.kondrak.spring.serviceactivators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Administrator on 6/24/2016.
 */
@Service
public class MessageLoggerService {
    @Autowired
    JmsTemplate jmsTemplate;

    @ServiceActivator(inputChannel = "endChannel")
    public void activate(String payload) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(payload);
            }
        };

        System.out.println("IN MESSAGE LOGGER SERVICE: " + payload);
        jmsTemplate.send("logger-destination", messageCreator);
    }
}
