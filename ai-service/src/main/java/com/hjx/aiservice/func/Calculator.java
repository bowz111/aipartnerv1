package com.hjx.aiservice.func;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-19
 * @Description:
 * @Version: 1.0
 */

public class Calculator implements Runnable{
    private int a;
    private int b;
    @Override
    public void run(){
        System.out.println(a+b);
    }
}
