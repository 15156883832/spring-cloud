spring cloud,主要组件简单介绍：
  1.注册中心：eureka，高可用集群，AP(高可用性和分区容错性)；
  2.服务间通信：两种方式：@Feign注解和RestTemplate方式，调用前缀可用eureka中注册的服务名来代替IP和端口号；
  3.网关zuul：网关zuul集成了负载均衡ribbon，非常适用，负载均衡时也可用eureka中的服务名。

spring cloud框架搭建中会经历过不少坑，慎重查看项目中的README.txt,同事项目中也继承了Redis和RabbitMq,注意适用规范，不用的话自己自行关闭。
