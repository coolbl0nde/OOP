package com.example.murmur.entities;

import com.example.murmur.managers.ChatManager;

import java.util.*;

public class Chat {

    public static String createChat(List<String> users){
        String id = ChatManager.addChat(users);

        return id;
    }

    public static String createGroupChat(List<String> users, String name){
        String id = ChatManager.addGroupChat(users, name);

        return id;
    }

    public static String sendMessage(String text, String senderId, String id){
        return ChatManager.sendMessage(text, senderId, id);
    }

    public static void deleteMessage(String messageId, String id){
        ChatManager.deleteMessage(messageId, id);
    }

    public static List<String> messagesList(String id){
        return ChatManager.messagesList(id);
    }

    public static List<String> getUsers(String id){ return ChatManager.getUsers(id); }

    public static void deleteChat(String id){
        ChatManager.deleteChat(id);
    }

    public static Map<String, Object> getChatInfo(String id){ return ChatManager.getChatInfo(id); }

}
