package org.example.backend.web;

import org.example.backend.chat.ChatMessage;
import org.example.backend.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketHandler {

    private final ChatService chatService;

    @Autowired
    public WebSocketHandler(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/sub/chat")
    public ChatMessage send(@Payload ChatMessage message) throws Exception {
        message.setSender("hi");
        return message; // 받은 메시지를 그대로 반환
    }
}