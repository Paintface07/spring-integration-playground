package org.kondrak.spring;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 6/23/2016.
 */
@Component
public class MyServiceActivator {

    @ServiceActivator(inputChannel = "outputChannel")
    public void activate(String payload) {
        System.out.println("IN SERVICE ACTIVATOR : " + payload);
//        return payload;
    }
}
