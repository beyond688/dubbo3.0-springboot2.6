# dubbo3.0-springboot2.6
整合dubbo3.0和springboot2.6，并给出dubbo自带的限流和降级例子

<strong>觉得有用的朋友请帮忙点个♥♥♥star♥♥♥</strong>

说明：因为dubbo自带限流方式没有对QPS维度进行限流，并且不支持熔断

所以平时项目中可以引用sentinel框架实现这些dubbo不支持的这些功能

dubbo和sentinel整合的项目地址：https://github.com/beyond688/dubbo3.0-sentinel

<strong>一、启动dubbo3.0-springboot2.6项目</strong>

1、启动DubboProviderApplication

2、启动DubboConsumerApplication

注意：dubbo.registry.address = zookeeper://192.168.240.132:2181

ip换成实际的地址

<strong>二、调用限流接口</strong>

限流配置在ExecutesDemoServiceImpl中

@DubboService(methods = {
@Method(name = "useExecutes1", executes = 1),
@Method(name = "useExecutes2", executes = 2)
})

useExecutes1方法配置执行并行度为1个线程

useExecutes2方法配置执行并行度为2个线程

调用链接如下：

useExecutes1方法：  http://127.0.0.1:9091/useExecutes1/beyond

useExecutes2方法：  http://127.0.0.1:9091/useExecutes2/beyond

运行结果如下：

![image](https://user-images.githubusercontent.com/39320802/166424807-4bcdf702-d15e-47e4-9124-0a1e06dfe706.png)


<strong>三、调用降级接口</strong>

限流配置在ReferenceConfiguration中

/**
* dubbo降级一般是dubbo的超时设置 + 配置mock 类 配合使用的
* MockDemoServiceImpl设置的超时时间是5000毫秒
* useMock1执行时间需要10000毫秒
* 所以调用useMock1方法时会被降级处理
* retries重试次数设置为0，因为降级的服务不需要重试机制
  */
  @DubboReference(check = false,timeout = 5000 , mock = "return null" , retries = 0)

调用链接如下：

http://127.0.0.1:9091/useMock1/beyond

运行结果如下：

![image](https://user-images.githubusercontent.com/39320802/166424782-806b397d-23c2-4c5b-ade4-08f099c7190e.png)



