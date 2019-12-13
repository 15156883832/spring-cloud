package com.order.orderserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//exclude里面的很关键，不然启动会报关于‘url’的错
@MapperScan("com.order.orderserver")//扫描接口类
@EnableFeignClients
public class OrderServerJqApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerJqApplication.class, args);
    }

}
