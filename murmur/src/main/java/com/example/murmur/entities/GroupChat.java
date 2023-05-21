package com.example.murmur.entities;

import com.example.murmur.managers.ChatManager;

import java.util.List;

public class GroupChat extends Chat {

    public static void addUser(String userId, String id){
        ChatManager.addUser(userId, id);
    }

    public static void deleteUser(String userId, String id){
        ChatManager.deleteUser(userId, id);
    }

    public static String getGroupName(String id){
        return ChatManager.getGroupName(id);
    }

    public static void setGroupName(String name, String id){
        ChatManager.setGroupName(name, id);
    }

}
