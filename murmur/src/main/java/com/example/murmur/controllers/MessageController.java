package com.example.murmur.controllers;

import com.example.murmur.entities.Message;
import com.example.murmur.entities.Chat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MessageController {

    @GetMapping("api/message")
    public ResponseEntity<Map<String, Object>> messageInfo(@RequestParam String id){
        Map<String, Object> message =  Message.getMessageInfo(id);

        System.out.println(message);

        if(message.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(message);
        }
    }

    @DeleteMapping("api/message")
    public ResponseEntity<String> deleteMessage(@RequestBody Map<String, Object> message){
        if(message.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Chat.deleteMessage((String) message.get("messageId"), (String) message.get("chatId"));
            return ResponseEntity.ok("success");
        }
    }

    @PutMapping("api/message")
    public ResponseEntity<String> editMessage(@RequestBody Map<String, Object> message){
        if(message != null){
            Message.setText((String) message.get("text"), (String) message.get("id"));
            return ResponseEntity.ok("success");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
