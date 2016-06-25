package org.kondrak.spring.routers;

import org.springframework.integration.annotation.Router;
import org.springframework.stereotype.Component;

/**
 * Created by kondrak on 6/23/2016.
 */
@Component
public class MyRouter {
    @Router(inputChannel = "inputChannel", defaultOutputChannel = "outputChannel")
    public String route(String rString) {
        System.out.println("ROUTING MESSAGE : " + rString);
        Integer val = null;
        try {
            val = Integer.valueOf(rString);
        } catch (NumberFormatException ex) {
            if(rString.contains("s")) {
                return "jdbcChannel";
            } else {
                return "endChannel";
            }
        }
        return "outputChannel";
    }
}
