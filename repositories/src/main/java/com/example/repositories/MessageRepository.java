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

        return MessageRepository.toMessageDTO(responseMessage.getBody());
    }

    private static Map<String, Object> toMessageDTO(Map<String, Object> message){

        String senderId = (String) message.get("sender");
        Map<String, Object> sender = UserRepository.getUserInfo(senderId);

        message.put("sender", sender);

        return message;
    }
}
