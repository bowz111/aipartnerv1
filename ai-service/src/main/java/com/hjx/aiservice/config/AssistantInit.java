package com.hjx.aiservice.config;

import com.hjx.aiservice.service.Assistant;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-15
 * @Description:
 * @Version: 1.0
 */
@Configuration
@RequiredArgsConstructor
public class AssistantInit {

    private final ChatLanguageModel chatLanguageModel;

    //基于内存的向量数据库
    @Bean
    public EmbeddingStore<TextSegment> initEmbeddingStore(){
        return new InMemoryEmbeddingStore<>();
    }

    @Bean
    public Assistant init(EmbeddingStore<TextSegment> embeddingStore){
        return AiServices.builder(Assistant.class)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore)) //写入向量数据库
                .chatLanguageModel(chatLanguageModel).build();
    }
}
