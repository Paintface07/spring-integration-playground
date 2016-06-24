package org.kondrak.spring;

import org.kondrak.spring.gateways.MyGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Administrator on 6/22/2016.
 */
@SpringBootApplication
public class IntegrationApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(IntegrationApp.class, args);
        MyGateway gateway = (MyGateway) ctx.getBean("myGateway");
        gateway.echo("Hello World!");
        ctx.close();
    }
}
