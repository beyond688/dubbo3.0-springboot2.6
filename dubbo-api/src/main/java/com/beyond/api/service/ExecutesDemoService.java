package com.beyond.api.service;

/**
 * ExecutesDemoService
 * 限流测试接口
 * @author liujh
 * @date 2022/05/01
 */
public interface ExecutesDemoService {

    /**
     * 限流测试接口1
     *
     * @param name 名称
     * @return result
     *
     */
    String useExecutes1(String name);

    /**
     * 限流测试接口2
     *
     * @param name 名称
     * @return result
     *
     */
    String useExecutes2(String name);

}
