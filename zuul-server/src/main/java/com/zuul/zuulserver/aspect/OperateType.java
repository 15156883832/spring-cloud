package com.zuul.zuulserver.aspect;

public enum OperateType {

    UNKNOWN("unknown","未知的操作"),
    DELETE("delete","删除操作"),
    SELECT("select","查询操作"),
    UPDATE("update","更新操作"),
    INSERT("insert","新增");
    private String name;
    private String desc;

    OperateType (String name,String desc){
        this.name=name;
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}
