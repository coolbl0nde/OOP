package com.example.murmur.entities;

import com.example.murmur.managers.ChatManager;

import java.util.*;

public class Chat {

    protected final String id;

    public Chat(List<String> users){
        this.id = String.valueOf(new Random().nextInt());

        ChatManager.addChat(this.id, users);
    }

    public Chat(List<String> users, String name){
        this.id = String.valueOf(new Random().nextInt());

        ChatManager.addGroupChat(id, users, name);
    }

    public static String createChat(List<String> users){
        String id = String.valueOf(new Random().nextInt());

        ChatManager.addChat(id, users);

        return id;
    }

    public static String createGroupChat(){
        return null;
    }

    public String getId(){
        return this.id;
    }

    public void sendMessage(String text, String senderId){
        ChatManager.sendMessage(text, senderId, this.id);
    }

    public void deleteMessage(String messageId){
        ChatManager.deleteMessage(messageId, this.id);
    }

    public Map<String, String > messagesList(){
        return ChatManager.messagesList(this.id);
    }

    public static void deleteChat(String chatId){
        ChatManager.deleteChat(chatId);
    }

}
