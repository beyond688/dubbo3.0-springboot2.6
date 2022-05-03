package com.beyond.consumer.controller;

import com.beyond.api.service.ExecutesDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * DemoConsumerController
 * 消费者控制层
 * @author liujh
 * @date 2022/05/01
 */
@RestController
public class DemoConsumerController {

    @Autowired
    private ExecutesDemoService executesDemoService;

    @RequestMapping("/useExecutes1/{name}")
    public String useExecutes1(@PathVariable("name") String name) {
        return executesDemoService.useExecutes1(name);
    }

    @RequestMapping("/useExecutes2/{name}")
    public String useExecutes2(@PathVariable("name") String name) {
        return executesDemoService.useExecutes2(name);
    }

}
