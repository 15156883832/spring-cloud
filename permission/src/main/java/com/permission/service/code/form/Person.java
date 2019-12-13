package com.permission.service.code.form;

import java.util.Date;

public class Person {

    private String name;
    private Integer age;
    private Date burn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBurn() {
        return burn;
    }

    public void setBurn(Date burn) {
        this.burn = burn;
    }
}
