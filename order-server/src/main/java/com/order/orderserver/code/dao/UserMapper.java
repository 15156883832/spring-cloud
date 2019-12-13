package com.order.orderserver.code.dao;

import com.order.orderserver.code.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<Map<String,Object>> getListUser();

    int updateSql(String name);

    int updateErrorSql(String name);

    int saveUser(User user);

}
