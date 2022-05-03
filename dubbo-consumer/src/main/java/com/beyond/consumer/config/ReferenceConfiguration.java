package com.beyond.consumer.config;

import com.beyond.api.service.ExecutesDemoService;
import com.beyond.api.service.MockDemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ReferenceConfiguration
 * dubbo中的bean配置类
 *
 * @author liujh
 * @date 2022/05/01
 */
@Configuration
public class ReferenceConfiguration {
    // 依托于Spring容器的好处在于职责的划分更加清晰，dubbo本身只负责于rpc的通信，而bean的管理交还给spring，
    // 而且使ReferenceAnnotationBeanPostProcessor类更加轻，dubbo的关注点更加集中。

    @Bean
    @DubboReference(check = false)
    public ReferenceBean<ExecutesDemoService> executesDemoService() {
        return new ReferenceBean();
    }

    /**
     * dubbo降级一般是dubbo的超时设置 + 配置mock 类 配合使用的
     * MockDemoServiceImpl设置的超时时间是5000毫秒
     * useMock1执行时间需要10000毫秒
     * 所以调用useMock1方法时会被降级处理
     * retries重试次数设置为0，因为降级的服务不需要重试机制
     */
    @Bean
    @DubboReference(check = false,timeout = 5000 , mock = "return null" , retries = 0)
    public ReferenceBean<MockDemoService> mockDemoService() {
        return new ReferenceBean();
    }

}
