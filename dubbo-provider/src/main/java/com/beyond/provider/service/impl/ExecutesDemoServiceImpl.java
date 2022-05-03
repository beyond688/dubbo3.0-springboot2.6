package com.beyond.provider.service.impl;

import com.beyond.api.service.ExecutesDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;

/**
 * ExecutesDemoServiceImpl
 * 服务提供类(限流设置)
 * executes直接限流– 仅提供者端
 * 该属性仅能设置在提供者端。可以设置为接口级别，也可以设置为方法级别。限制的是服务（方法）并发执行数量。
 *
 * useExecutes1方法并发执行数量为1
 * useExecutes2方法并发执行数量为2
 *
 * @author liujh
 * @date 2022/05/01
 */
@Slf4j
@DubboService(methods = {
        @Method(name = "useExecutes1", executes = 1),
        @Method(name = "useExecutes2", executes = 2)
})
public class ExecutesDemoServiceImpl implements ExecutesDemoService {

    public static int num1 = 0;

    public static int num2 = 0;

    @Override
    public String useExecutes1(String name) {

        log.info("限流接口1被访问次数：" + (++num1));

        int count = num1;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(name + "对限流接口1的第" + count + "次访问完成");

        return name + "对限流接口1的第" + count + "次访问完成";
    }

    @Override
    public String useExecutes2(String name) {

        log.info("限流接口2被访问次数：" + (++num2));

        int count = num2;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(name + "对限流接口2的第" + count + "次访问完成");

        return name + "对限流接口2的第" + count + "次访问完成";
    }
}
