package com.example.murmur.managers;

import com.example.murmur.entities.User;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {
    private static DataBase dataBase = DataBase.getInstance();

    public static String addMessage(String text, String date, String time, String senderId){
        Map<String, Object> messageData = new HashMap<>();

        messageData.put("text", text);
        messageData.put("date", date);
        messageData.put("time", time);
        messageData.put("sender", senderId);

        String id = dataBase.insert(messageData,"message");

        return id;
    }

    public static String getSender(String id){
        String sender = (String) dataBase.getFieldValue(id, "sender", "message");

        return (String) User.getName(sender);
    }
    public static String getText(String id){
        String text = (String) dataBase.getFieldValue(id, "text", "message");

        return text;
    }

    public static void setText(String text, String id){
        dataBase.update(id, "text", text, "message");
    }

    public static String getDate(String id){
        String date = (String) dataBase.getFieldValue(id, "date", "message");

        return date;
    }

    public static String getTime(String id){
        String time = (String) dataBase.getFieldValue(id, "time", "message");

        return time;
    }

    public static Map<String,Object> getMessageInfo(String id){
        Map<String, Object> message = dataBase.get(id, "message");

        return message;
    }
}
