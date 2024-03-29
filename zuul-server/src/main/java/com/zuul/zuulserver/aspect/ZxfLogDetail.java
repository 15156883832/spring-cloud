package com.zuul.zuulserver.aspect;


import org.springframework.boot.actuate.endpoint.OperationType;

import java.lang.annotation.*;
/**
 *
 * 自定义注解
 *
 * **/
//@ZxfLogDetail(detail = "通过手机号[{{tel}}]获取用户名",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
@Documented
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxfLogDetail {
    /**
     * 方法描述,可使用占位符获取参数:{{tel}}
     */
    String detail() default "";

    /**
     * 日志等级:自己定，此处分为1-9
     */
    int level() default 0;

    /**
     * 操作类型(enum):主要是select,insert,update,delete
     */
    OperateType operationType() default OperateType.UNKNOWN;

    /**
     * 被操作的对象(此处使用enum):可以是任何对象，如表名(user)，或者是工具(redis)
     */
    OperateUnit operationUnit() default OperateUnit.UNKNOWN;
}
