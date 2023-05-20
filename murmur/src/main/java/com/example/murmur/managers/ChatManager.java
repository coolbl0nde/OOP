package com.example.murmur.managers;
import com.example.murmur.entities.Message;
import com.example.murmur.entities.User;

import java.util.*;
public class ChatManager {
    private static DataBase dataBase = DataBase.getInstance();

    public ChatManager(){
    }

    public static String addChat(List<String> users){
        List<String> idMessages = new ArrayList<>();
        Map<String, Object> chatData = new HashMap<>();

        chatData.put("users", users);
        chatData.put("messages", idMessages);

        String id = dataBase.insert(chatData, "chat");

        return id;
    }

    public static String addGroupChat(List<String> users, String name){
        List<String> idMessages = new ArrayList<>();
        Map<String, Object> chatData = new HashMap<>();

        chatData.put("users", users);
        chatData.put("messages", idMessages);
        chatData.put("name", name);

        String id = dataBase.insert(chatData, "chat");

        return id;
    }

    public static String sendMessage(String text, String senderId, String chatId){
        String messageId = Message.createMessage(text, senderId);
        List<String> messages = (List<String>) dataBase.getFieldValue(chatId, "messages", "chat");

        messages.add(messageId);

        dataBase.update(chatId, "messages", messages, "chat");

        return messageId;
    }

    public static void deleteMessage(String messageId, String chatId){
        List<String> messages = (List<String>) dataBase.getFieldValue(chatId, "messages", "chat");

        messages.remove(messageId);

        dataBase.update(chatId, "messages", messages, "chat");
        dataBase.delete(messageId, "message");
    }

    public static List<String> messagesList(String chatId){
        //sender - text
        List<String> messages = (List<String>) dataBase.getFieldValue(chatId, "messages", "chat");

        return messages;
    }

    public static void deleteChat(String chatId) {
        List<String> messages = (List<String>) dataBase.getFieldValue(chatId, "messages", "chat");

        dataBase.delete(chatId, "chat");

        for(String message : messages){
            dataBase.delete(message, "message");
        }
    }

    public static void addUser(String userId, String groupChatId){
        List<String> users = (List<String>) dataBase.getFieldValue(groupChatId, "users", "chat");

        users.add(userId);

        dataBase.update(groupChatId, "users", users, "chat");
    }

    public static void deleteUser(String userId, String groupChatId){
        List<String> users = (List<String>) dataBase.getFieldValue(groupChatId, "users", "chat");

        users.remove(userId);

        dataBase.update(groupChatId, "users", users, "chat");
    }

    public static String getGroupName(String groupChatId){
        String name = (String) dataBase.getFieldValue(groupChatId, "name", "chat");

        return name;
    }

    public static void setGroupName(String name, String groupChatId){
        dataBase.update(groupChatId, "name", name,"chat");
    }

    public static List<String> getNameOfUsers(String groupChatId){
        //name of users
        List<String> users = (List<String>) dataBase.getFieldValue(groupChatId, "users", "chat");

        return users;
    }

    public static Map<String, Object> getChatInfo(String id){
        Map<String, Object> chat = dataBase.get(id,"chat");

        return chat;
    }
}
