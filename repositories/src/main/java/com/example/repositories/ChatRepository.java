package com.example.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChatRepository {

    public static Map<String, Object> getChatInfo(String id){

        RestTemplate restTemplate = new RestTemplate();

        String urlChat = "http://localhost:8080/api/chat?id={id}";

        ResponseEntity<Map> responseChat = restTemplate.getForEntity(urlChat, Map.class, id);

        Map<String, Object> chat = responseChat.getBody();

        List<String> users = (List<String>) chat.get("users");
        List<Map<String, Object>> userObjects = new ArrayList<>();

        for(String user : users){
            userObjects.add(UserRepository.getUserInfo(user));
        }

        chat.put("users", userObjects);

        List<String> messages = (List<String>) chat.get("messages");
        List<Map<String, Object>> messageObjects = new ArrayList<>();

       for(String message : messages){
            messageObjects.add(MessageRepository.getMessageInfo(message));
        }

        chat.put("messages", messageObjects);

        return chat;
    }
}
