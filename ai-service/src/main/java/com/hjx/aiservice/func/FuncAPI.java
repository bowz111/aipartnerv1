package com.hjx.aiservice.func;

import com.hjx.aiservice.service.Assistant;
import com.hjx.aiservice.util.JsonUtil;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.request.ChatRequestParameters;
import dev.langchain4j.model.chat.request.json.JsonObjectSchema;
import dev.langchain4j.model.chat.response.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-19
 * @Description:
 * @Version: 1.0
 */
@RequestMapping("/api/func")
@RestController
@RequiredArgsConstructor
public class FuncAPI {

    private final Assistant assistant;

    private final ChatLanguageModel chatLanguageModel;

    @GetMapping("/low/chat")
    public String lowChat(@RequestParam(value = "message") String message){
        ToolSpecification specification = ToolSpecification.builder()
                .name("Calculator")
                .description("输入两个数，对这两个数求和")
                .parameters(JsonObjectSchema.builder()
                        .addIntegerProperty("a","第一个参数")
                        .addIntegerProperty("b","第二个参数")
                        .required("a","b")
                        .build())
                .build();

        ChatResponse chatResponse = chatLanguageModel.doChat(ChatRequest.builder()
                        .messages(List.of(UserMessage.from(message)))
                        .parameters(ChatRequestParameters.builder()
                                .toolSpecifications(specification)
                                .build())
                .build());

        chatResponse.aiMessage().toolExecutionRequests().forEach(toolExecutionRequest ->{
            System.out.println(toolExecutionRequest.name());
            System.out.println(toolExecutionRequest.arguments());
            try {
                Class<?> aClass = Class.forName("com.hjx.aiservice.func." + toolExecutionRequest.name());
                Runnable jsonObject = (Runnable)JsonUtil.toJsonObject(toolExecutionRequest.arguments(), aClass);
                jsonObject.run();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });


        return chatResponse.aiMessage().text();
    }

    @GetMapping("/high/chat")
    public String highChat(@RequestParam(value = "message") String message){
        return assistant.chat(message);
    }
}
