package com.order.orderserver.code.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Service
@FeignClient(name="permission",path="permission")
public interface TestService {

    @PostMapping(value="/user/getUserList")
    public List<Map<String,Object>> getUserList();
}
