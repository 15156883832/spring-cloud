服务之间通讯RestTemplate和Feign配置笔记：
    1）RestTemplate: 该方式也有好几种配置途径，但是最优的选择还是加RestTemplateConfig,
        里面有加@LoadBalanced注解的RestTemplate,这样url中相互调用的话ip:port就可以使用eureka中
        的服务名了，但是RestTemplate post请求传参时要注意参数的格式要求MultiValueMap,而不是
        普通任何格式的JSON,实例中根据java反射已经生成了一些实体转MultiValueMap的泛型方法
    2）Feign: 使用Feign的话要注意与RestTemplate接口分开，同时注意Feign中配置的路劲，
        优先选择Feign

