package com.order.orderserver.code;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="helloworld")
public class HelloController {

    @RequestMapping("/index")
    public String helloWorld(HttpServletRequest request){

        return "Hello World! Order-server-jq !!!";
    }
}
