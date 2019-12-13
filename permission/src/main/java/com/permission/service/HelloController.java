package com.permission.service;

import com.permission.service.code.form.Person;
import com.permission.service.code.util.SelfHttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/hello")
public class HelloController extends BaseController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public String helloWorld(HttpServletRequest reqeust){

        return "Hello world!";
    }

    // 1.服务间通信-------RestTemplate通信方式
    @ResponseBody
    @RequestMapping("/testExchange")
    public String  testExchange(){
        Map<String,Object> mapMq = new HashMap<>();
        mapMq.put("name","Jerry");
        //String str = restTemplate.getForObject("http://permission/permission/user/toStringData", String.class);
        Person p = new Person();
        p.setName("cat");
        p.setAge(24);
        p.setBurn(new Date());
        //其中服务的第一个order就是eureka中的要访问的注册服务名
        ResponseEntity<Person>  entity = restTemplate.postForEntity("http://order/order/user/toEntityData", SelfHttpUtils.etyDeal(p),Person.class);
        Person person = entity.getBody();
        ResponseEntity<Map>  mapRt = restTemplate.postForEntity("http://order/order/user/toMapData", SelfHttpUtils.etyDeal(p),Map.class);

        //ResponseEntity<String>  mapStr = restTemplate.postForEntity("http://permission/permission/user/toStringData", SelfHttpUtils.etyDeal(p),String.class);

        String s1 = restTemplate.postForObject("http://order/order/user/toMapData",SelfHttpUtils.mapDeal(mapMq),String.class);
        String result = restTemplate.getForObject("http://order/order/user/toStringData", String.class);
        return "this is requestResult:" + result;
    }
}
