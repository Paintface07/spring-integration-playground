package org.kondrak.spring;

import org.apache.commons.io.FileUtils;
import org.kondrak.spring.gateways.MyGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;

/**
 * Created by kondrak on 6/22/2016.
 */
@SpringBootApplication
public class IntegrationApp {

    public static void main(String[] args) {
//        setupFileWriterMessageDirectory();
        ConfigurableApplicationContext ctx = SpringApplication.run(IntegrationApp.class, args);
//        MyGateway gateway = (MyGateway) ctx.getBean("myGateway");
//        gateway.echo("Hello World!");
//        gateway.echo("298473");
//        gateway.echo("say hello!");
//        ctx.close();
    }

    private static void setupFileWriterMessageDirectory() {
        try {
            File m = new File("messages");
            if(m.exists()) {
                FileUtils.cleanDirectory(m);
            } else {
                m.createNewFile();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
