package org.kondrak.spring.receivers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

/**
 * Created by Administrator on 6/24/2016.
 */
@Component
public class LoggerReceiver {

    @JmsListener(destination = "logger-destination", containerFactory = "jmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Message: " + message);
    }
}
