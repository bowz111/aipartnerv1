package com.hjx.aiservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import dev.langchain4j.web.search.searchapi.SearchApiWebSearchEngine;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-19
 * @Description:
 * @Version: 1.0
 */
@Configuration
@RequiredArgsConstructor
public class WebSearchInit {

    private final SearchConfig searchConfig;

    public SearchApiWebSearchEngine initWebSearchEngine(){
        return SearchApiWebSearchEngine.builder()
                .engine(searchConfig.getEngine())
                .apiKey(searchConfig.getApiKey())
                .build();
    }
}
