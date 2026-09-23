package com.example.aierrorexplainer.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {

    private final ChatClient chatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String explainError(String error) {

       String prompt = """
                You are a Java programming error explainer.

                Explain the following error in very simple terms for a beginner.

                Use exactly these four sections:

                1. What the Error Means
                2. Why It Happened
                3. How to Fix It
                4. Simple Example

                Important:
                - Do not use Markdown formatting.
- Do not use backslashes.
- Do not use # symbols.
- Do not use * symbols.
- Do not use backticks.
- Do not use code fences.
- Write everything as normal plain text.

                Error:
                """ + error;
                   

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}