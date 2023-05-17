package com.example.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class MessageRepository {

    public static Map<String, Object> getMessageInfo(String messageId){
        String urlMessage = "http://localhost:8080/api/message?id={id}";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseMessage = restTemplate.getForEntity(urlMessage, Map.class, messageId);

        return responseMessage.getBody();
    }

    public static List<Map<String, Object>> chatMessages(String chatId){

        Map<String, Object> chat = ChatRepository.getChatInfo(chatId);

        return (List<Map<String, Object>>)chat.get("messages");
    }
}
