# 项目说明
eureka：

    注册服务中心，会注册到服务中心的项目：config、feign、gateway、hi-service、ribbon、zuul
    
config：

    配置服务中心， 从配置服务中心拿配置的项目：feign、gateway、hi-service、ribbon、zuul
  
# 网关
gateway、zuul：

    gateway的配置说明，和zuul同是网关，使用一个就好
    
# 需求项目
feign：

    feign的使用例子，包括容错。
  
 ribbon：
 
    ribbon和hystrix的使用例子
    
 hi-service:
 
    供feign和ribbon调用的项目
    
 # 运行说明
 顺序：
 
    1.eureka
    2.config
    3.gateway或zuul，两个都运行也行
    4.feign、ribbon和hi-service
 
 测试接口：
 
    http://localhost:8086/admin/hi?name=wilmiam
    请求zuul网关，匹配/admin路由到feign项目
    
    http://localhost:8088/feign/hi?name=wilmiam
    请求gateway网关，匹配/admin路由到feign项目
    
    http://localhost:8088/elapse/hi?name=wilmiam&token=123123
    请求gateway经过网关的自定义指定路由 RequestTimeGatewayFilterFactory，排序同级的时候全局路由优先于指定路由