package com.example.murmur.entities;

import com.example.murmur.managers.ChatManager;

import java.util.List;

public class GroupChat extends Chat {
    public GroupChat(String firstUser, String secondUser, String name){
        super(firstUser, secondUser, name);
    }

    public void addUser(String userId){
        ChatManager.addUser(userId, this.id);
    }

    public void deleteUser(String userId){
        ChatManager.deleteUser(userId, this.id);
    }

    public String getGroupName(){
        return ChatManager.getGroupName(this.id);
    }

    public void setGroupName(String name){
        ChatManager.setGroupName(name, this.id);
    }

    public List<String> getNameOfUsers(){
        return ChatManager.getNameOfUsers(this.id);
    }
}
