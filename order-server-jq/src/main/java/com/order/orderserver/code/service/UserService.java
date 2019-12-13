package com.order.orderserver.code.service;

import com.order.orderserver.code.dao.UserMapper;
import com.order.orderserver.redisConfig.RedisService;
import com.order.orderserver.redisConfig.impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper dao;

    @Autowired
    RedisServiceImpl redisService;

    public List<Map<String,Object>> getUserList(){
        redisService.set("11","哈哈");
        return dao.getListUser();
    }
}
