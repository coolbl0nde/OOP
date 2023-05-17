package com.example.murmur.controllers;

import com.example.murmur.entities.Chat;
import com.example.murmur.managers.ChatManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class ChatController {

    @GetMapping("/api/chat")
    public ResponseEntity<Map<String, Object>> getChat(@RequestParam String id){
        Map<String, Object> chat = ChatManager.getChatInfo(id);

        if(chat.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(chat);
        }
    }

    @PostMapping("/api/chat")
    public ResponseEntity<String> addChat(@RequestBody Map<String, Object> chat){

        if(chat.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(Chat.createChat((String) chat.get("idFirst"), (String) chat.get("idSecond")));
        }
    }

    @PostMapping("/api/message")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, Object> message){
        if(message.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(ChatManager.sendMessage((String) message.get("text"), (String) message.get("senderId"),
                    (String) message.get("chatId")));
        }
    }

    @DeleteMapping("api/chat")
    public ResponseEntity<String> deleteChat(@RequestBody Map<String, Object> chat){
        if(chat.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            ChatManager.deleteChat((String) chat.get("chatId"));

            return ResponseEntity.ok("success");
        }
    }
}
