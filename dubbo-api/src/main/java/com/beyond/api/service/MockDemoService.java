package com.beyond.api.service;

/**
 * MockDemoService
 * 降级测试接口
 * @author liujh
 * @date 2022/05/01
 */
public interface MockDemoService {

    /**
     * 降级测试接口1
     *
     * @param name 名称
     * @return result
     *
     */
    String useMock1(String name);


}
