package com.thehecklers.aoai_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AoaiController {
    private final ChatClient client;

    public AoaiController(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return client.prompt()
                .user(message)
                .call()
                .content();
    }
}
