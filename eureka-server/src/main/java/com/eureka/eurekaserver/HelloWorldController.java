package com.eureka.eurekaserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="helloWorld")
public class HelloWorldController {

    @RequestMapping("/index")
    public String toIndex(){
        return "Hello World! It is eureka server first!";
    }
}
