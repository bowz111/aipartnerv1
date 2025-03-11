package com.hjx.aiservice.controller;

import com.hjx.aiservice.feignClient.OrderServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-10
 * @Description: 测试AI服务接口控制类
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ai")
@RefreshScope
public class TestController {

    @Autowired
    private OrderServiceFeignClient orderServiceFeignClient;

    @PostMapping("/addOrder")
    public String aiOrder(){
        String res = orderServiceFeignClient.addOrder();
        return res;
    }

    @GetMapping("/test")
    public String test(){
        return "this is ai-service";
    }


}
