package com.hjx.aiservice.rag;

import com.hjx.aiservice.service.Assistant;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-15
 * @Description: 增强检索能力RAG
 * @Version: 1.0
 */

@RequestMapping("/api/rag")
@RestController
@RequiredArgsConstructor
public class RagAPI {

    private final Assistant assistant;

    @GetMapping("/high/chat")
    public String highChat(@RequestParam(value = "message") String message){
       return assistant.chat(message);
    }

    private final EmbeddingStore<TextSegment> embeddingStore;

    @GetMapping("/load")
    public String load(){
        //能解析所有类型的文件
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("D:\\idea_workspace\\aipartnerv1\\documents");
        EmbeddingStoreIngestor.ingest(documents,embeddingStore);
        return "success";
    }

}
