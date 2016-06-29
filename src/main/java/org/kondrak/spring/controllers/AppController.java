package org.kondrak.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 6/28/2016.
 */
@Controller
public class AppController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }
}
