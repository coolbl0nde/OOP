package com.example.murmur.controllers;

import com.example.murmur.entities.Chat;
import com.example.murmur.managers.ChatManager;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class ChatController {

    @GetMapping
    public Map<String, Object> getChat(@RequestParam Integer id){
        return null;
    }

    @PostMapping
    public void addChat(@RequestBody Chat chat){
        //ChatManager.addChat(chat.getId(), chat.);
    }

}
