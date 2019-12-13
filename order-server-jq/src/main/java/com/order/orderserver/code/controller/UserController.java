package com.order.orderserver.code.controller;

import com.order.orderserver.code.BaseController;
import com.order.orderserver.code.form.Person;
import com.order.orderserver.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value="user")
@Controller
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/getUserList")
    public List<Map<String,Object>> getUserList(){

        return userService.getUserList();
    }

    @RequestMapping("/toIndex")
    public String toIndex(){

        return "/pages/index";
    }

    @ResponseBody
    @RequestMapping("/toStringData")
    public String toStringData(){

        return "server exchange success!";
    }

    @ResponseBody
    @RequestMapping("/toEntityData")
    public Person toEntityData(HttpServletRequest request){
        Map<String,String> mapMq = getParams(request);
        String name = request.getParameter("name");
        Person person = new Person();
        person.setAge(25);
        person.setName(name);
        return person;
    }

    @ResponseBody
    @RequestMapping("/toMapData")
    public Map<String,Object> toMapData(HttpServletRequest request){
        Map<String,String> mapMq = getParams(request);
        String name = request.getParameter("name");
        Map<String,Object> map= new HashMap<>();
        map.put("name","Tom");
        map.put("age",25);
        return map;
    }
}
