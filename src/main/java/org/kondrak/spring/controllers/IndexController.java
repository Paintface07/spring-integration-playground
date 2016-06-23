package org.kondrak.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 6/22/2016.
 */

@RestController
public class IndexController {
    @RequestMapping("/") public String index() {
        return "Hello";
    }
}
