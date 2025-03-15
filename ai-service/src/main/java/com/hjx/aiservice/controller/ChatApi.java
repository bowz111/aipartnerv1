package com.hjx.aiservice.controller;

import com.hjx.aiservice.service.Assistant;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-15
 * @Description: 对话能力
 * @Version: 1.0
 */
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ChatApi {

    private final ChatLanguageModel chatLanguageModel;

    private final Assistant assistant;

    @GetMapping("/low/chat")
    public String lowChat(@RequestParam(value = "message") String message){
        return chatLanguageModel.chat(List.of(SystemMessage.systemMessage("假如你是特朗普，接下来你必须以特朗普的语气来进行对话"),
                UserMessage.userMessage(message)
                )).aiMessage().text();

        //return chatLanguageModel.chat(UserMessage.from(message)).aiMessage().text();
    }

    @GetMapping("/high/chat")
    public String highChat(@RequestParam(value = "message") String message){

        return assistant.chat(message);
    }


}
