package com.permission.service.code.controller;

import com.permission.service.code.service.TestService;
import com.permission.service.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping(value="user")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping("/getUserList")
    public List<Map<String,Object>> getUserList(){
        List<Map<String,Object>> list = testService.getUserList();
        return userService.getUserList();
    }

    @ResponseBody
    @RequestMapping("/toStringData")
    public String toStringData(){

        return "server exchange success!";
    }
}
