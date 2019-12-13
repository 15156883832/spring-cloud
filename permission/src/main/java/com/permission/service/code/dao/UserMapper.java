package com.permission.service.code.dao;

import com.permission.service.code.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

//@FeignClient(name="order")
public interface UserMapper {

    /*@PostMapping(value={"/user/getUserList"},path="order")
    List<Map<String,Object>> getUserList();*/

    List<Map<String,Object>> getListUser();

    int updateSql(String name);

    int updateErrorSql(String name);

    int saveUser(User user);

}
