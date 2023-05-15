package com.example.murmur.repositories;

import com.example.murmur.managers.MessageManager;

import java.util.Map;

public class MessageRepository {

    public Map<String, Object> getMessageInfo(String id){
        return MessageManager.getMessageInfo(id);
    }
}
