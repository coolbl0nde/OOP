package com.example.murmur.entities;

import com.example.murmur.managers.ChatManager;

import java.util.List;

public class GroupChat extends Chat {

    public void addUser(String userId, String id){
        ChatManager.addUser(userId, id);
    }

    public void deleteUser(String userId, String id){
        ChatManager.deleteUser(userId, id);
    }

    public String getGroupName(String id){
        return ChatManager.getGroupName(id);
    }

    public void setGroupName(String name, String id){
        ChatManager.setGroupName(name, id);
    }

    public List<String> getNameOfUsers(String id){
        return ChatManager.getNameOfUsers(id);
    }
}
