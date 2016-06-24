package org.kondrak.spring.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 6/23/2016.
 */
@MessagingGateway(name = "myGateway", defaultRequestChannel = "inputChannel")
public interface MyGateway {
    void echo(String payload);
}
