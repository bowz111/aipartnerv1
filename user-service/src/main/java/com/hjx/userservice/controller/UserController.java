package com.hjx.userservice.controller;

import com.hjx.commonmodule.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-11
 * @Description: 用户相关接口
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String login(){
        //验证账号密码
        //jwt生成token
        String token = JwtUtil.getToken("123");
        //将token存入redis
        redisTemplate.opsForValue().set(token,token,JwtUtil.TOKEN_TIME_OUT, TimeUnit.SECONDS);
        //将token返回客户端
        return token;
    }
}
