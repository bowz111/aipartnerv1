package com.hjx.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-11
 * @Description: 订单控制类
 * @Version: 1.0
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
    @Value("${config.info}")
    private String configInfo;

    @PostMapping("/add")
    public String addOrder(){
        return "add order success";
    }

    @GetMapping("/test")
    public String test(){
        return "this is a order-service";
    }

    @GetMapping("/test/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
