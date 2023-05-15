package com.example.murmur.repositories;

import com.example.murmur.managers.ChatManager;
import com.example.murmur.managers.MessageManager;
import com.example.murmur.managers.UserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChatRepository {

    public Map<String, Object> getChatInfo(String id){
        Map<String, Object> chat = ChatManager.getChatInfo(id);
        List<String> users = (List<String>) chat.get("users");
        List<Map<String, Object>> userObjects = new ArrayList<>();

        for(String user : users){
            userObjects.add(UserManager.getUser(user));
        }

        chat.put("users", userObjects);

        List<String> messages = (List<String>) chat.get("messages");
        List<Map<String, Object>> messageObjects = new ArrayList<>();

        for(String message : messages){
            messageObjects.add(MessageManager.getMessageInfo(message));
        }

        chat.put("messages", messageObjects);

        return chat;
    }
}
