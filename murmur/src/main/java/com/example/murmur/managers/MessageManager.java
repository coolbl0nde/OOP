package com.example.murmur.managers;

import com.example.murmur.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageManager {
    private static DataBase dataBase = DataBase.getInstance();

    public MessageManager(){
    }

    public static void addMessage(String id, String text, String date, String time, String senderId){
        Map<String, Object> messageData = new HashMap<>();

        messageData.put("id", id);
        messageData.put("text", text);
        messageData.put("date", date);
        messageData.put("time", time);
        messageData.put("sender", senderId);

        dataBase.insert(messageData,"message");
    }

    public static String getSender(String id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                String senderId = (String) message.get("sender");
                return (String) User.getName(senderId);
            }
        }

        return null;
    }
    public static String getText(String id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                return (String) message.get("text");
            }
        }

        return null;
    }

    public static void setText(String text, String id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                message.put("text", text);
                break;
            }
        }
    }

    public static String getDate(String id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                return (String) message.get("date");
            }
        }

        return null;
    }

    public static String getTime(String id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                return (String) message.get("time");
            }
        }

        return null;
    }

    public static Map<String,Object> getMessageInfo(String id){
        List<Map<String, Object>> messages = dataBase.get("message");

        for(Map<String, Object> message : messages){
            if(message.get("id").equals(id)){
                return message;
            }
        }

        return null;
    }
}
