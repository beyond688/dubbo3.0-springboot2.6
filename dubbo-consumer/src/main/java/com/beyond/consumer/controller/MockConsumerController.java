package com.beyond.consumer.controller;

import com.beyond.api.service.MockDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * MockConsumerController
 * 消费者控制层
 *
 * @author liujh
 * @date 2022/05/01
 */
@RestController
public class MockConsumerController {

    @Autowired
    private MockDemoService mockDemoService;

    @RequestMapping("/useMock1/{name}")
    public String useMock1(@PathVariable("name") String name) {

        String result = mockDemoService.useMock1(name);

        if (result != null) {
            return result;
        } else {
            return "很遗憾告知你useMock1方法因为不重要被降级了";
        }

    }


}
