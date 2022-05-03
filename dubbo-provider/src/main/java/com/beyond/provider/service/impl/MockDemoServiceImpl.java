package com.beyond.provider.service.impl;

import com.beyond.api.service.MockDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;

/**
 * MockDemoServiceImpl
 * 服务提供类(降级设置)
 *
 * @author liujh
 * @date 2022/05/01
 */
@Slf4j
@DubboService
public class MockDemoServiceImpl implements MockDemoService {

    public static int num1 = 0;

    @Override
    public String useMock1(String name) {

        log.info("降级接口1被访问次数：" + (++num1));

        int count = num1;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(name + "对降级接口1的第" + count + "次访问完成");

        return name + "对降级接口1的第" + count + "次访问完成";
    }

}
