package com.hjx.userservice.controller;

import com.hjx.commonmodule.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    //application.yml配置文件中，设置token在redis中的过期时间
    @Value("${config.redisTimeout}")
    private Long redisTimeout;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String login(){
        //验证账号密码
        String userId = "123";
        //jwt生成token
        String token = JwtUtil.getToken(userId);
        //将token存入redis
        redisTemplate.opsForValue().set(token,userId,redisTimeout, TimeUnit.SECONDS);
        //将token返回客户端
        return token;
    }
}
