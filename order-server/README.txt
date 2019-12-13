eureka爬坑笔记：
    1.eureka 2.0之后的版本和之前的版本差别很大，要注意下

    2.eureka注册中心server即eureka-server,自身eureka属性一定要设置为不能将自己注册进去

    3.这个坑是真的有点坑，那就是服务端配置eureka的注册url时，最终url上都必须要加上eureka，配置了
      context-path=eureka-server的话，即localhost:8771/eureka-server/eureka，巨坑！！！
