package org.kondrak.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 6/22/2016.
 */

@RestController
public class IndexController {

//    @RequestMapping("/") public String index() {
//        System.out.println("*** IN CONTROLLER");
//        GenericMessage<String> message = new GenericMessage<>("My Message!");
////        handler.handleMessage(message);
//
//        return "Hello";
//    }
}
