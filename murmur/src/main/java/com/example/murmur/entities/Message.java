package com.example.murmur.entities;

import com.example.murmur.managers.MessageManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class Message {
    private final String id;

    public Message(String text, String senderId){
        this.id = String.valueOf(new Random().nextInt());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        MessageManager.addMessage(this.id, text, date, time, senderId);
    }

    public String getId(){
        return this.id;
    }

    public static String getSender(String id){
        return MessageManager.getSender(id);
    }

    public static String getText(String id){
        return MessageManager.getText(id);
    }

    public void setText(String text){
        MessageManager.setText(text, this.id);
    }

    public String getDate(){
        return MessageManager.getDate(this.id);
    }

    public String getTime(){
        return MessageManager.getTime(this.id);
    }
}
