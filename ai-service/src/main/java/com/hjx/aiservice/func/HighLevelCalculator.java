package com.hjx.aiservice.func;

import dev.langchain4j.agent.tool.Tool;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-19
 * @Description:
 * @Version: 1.0
 */

public class HighLevelCalculator {

    @Tool("计算两数之和")
    public int sum(int a,int b){
        return a+b;
    }
}
