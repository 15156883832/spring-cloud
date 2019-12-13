package com.zuul.zuulserver.aspect;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="helloWorld-one")
public class HelloWorldController {

    @RequestMapping("/index")
    @ZxfLogDetail(detail="测试切面日志",level=0,operationType=OperateType.UNKNOWN,operationUnit=OperateUnit.UNKNOWN)
    public String toIndex(){
        return "Hello World! It is eureka server first!";
    }
}
