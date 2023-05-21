package com.example.murmur.entities;

import com.example.murmur.managers.MessageManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class Message {

    public static String createMessage(String text, String senderId) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        String id = MessageManager.addMessage(text, date, time, senderId);

        return id;
    }

    public static String getSender(String id){
        return MessageManager.getSender(id);
    }

    public static String getText(String id){
        return MessageManager.getText(id);
    }

    public static void setText(String text, String id){
        MessageManager.setText(text, id);
    }

    public static String getDate(String id){
        return MessageManager.getDate(id);
    }

    public static String getTime(String id){
        return MessageManager.getTime(id);
    }

    public static Map<String,Object> getMessageInfo(String id){ return MessageManager.getMessageInfo(id); }

}
