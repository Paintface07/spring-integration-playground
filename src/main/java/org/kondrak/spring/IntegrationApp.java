package org.kondrak.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 6/22/2016.
 */
@SpringBootApplication
public class IntegrationApp {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(IntegrationApp.class, args);

//        System.out.println("Spring Beans injected:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for(String beanName : beanNames) {
//            System.out.println(beanName);
//        }

    }
}
