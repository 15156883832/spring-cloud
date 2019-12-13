package com.permission.service.code.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(name="order",path="order")
public interface TestService {

    @PostMapping(value="/user/getUserList")
    public List<Map<String,Object>> getUserList();
}
