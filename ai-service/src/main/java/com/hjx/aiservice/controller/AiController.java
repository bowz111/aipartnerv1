package com.hjx.aiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-10
 * @Description: AI服务接口控制类
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ai")
public class AiController {
    @GetMapping("/test")
    public String test(){
        return "this is ai-service";
    }
}
