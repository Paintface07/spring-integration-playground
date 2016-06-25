package org.kondrak.spring.gateways;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by kondrak on 6/23/2016.
 */
@MessagingGateway(name = "myGateway", defaultRequestChannel = "inputChannel")
public interface MyGateway {
    void echo(String payload);
}
