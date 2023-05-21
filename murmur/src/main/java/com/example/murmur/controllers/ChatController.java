package com.example.murmur.controllers;

import com.example.murmur.entities.Chat;
import com.example.murmur.entities.GroupChat;
import com.example.murmur.entities.Message;

import com.example.murmur.managers.UserManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatController {

    @GetMapping("/api/chat")
    public ResponseEntity<Map<String, Object>> getChat(@RequestParam String id){
        Map<String, Object> chat = Chat.getChatInfo(id);

        if(chat.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            chat.put("messages_total", ((List<String>)chat.get("messages")).size());
            chat.put("users_total", ((List<String>)chat.get("users")).size());

            chat.remove("messages");
            chat.remove("users");

            return ResponseEntity.ok(chat);
        }
    }

    @GetMapping("api/chat/messages")
    public ResponseEntity<Map<String, Object>> listMessages(@RequestParam String id){
        Map<String, Object> result = new HashMap<>();
        List<Object> messageInfo = new ArrayList<>();
        Map<String, Object> chat = Chat.getChatInfo(id);

        if(chat != null){
            List<String> messages = Chat.messagesList(id);

            for(String message : messages){
                messageInfo.add(Message.getMessageInfo(message));
            }

            result.put("total", messages.size());
            result.put("data", messageInfo);
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/chat/users")
    public ResponseEntity<Map<String, Object>> listUsers(@RequestParam String id){
        Map<String, Object> result = new HashMap<>();
        List<Object> userInfo = new ArrayList<>();
        Map<String, Object> chat = Chat.getChatInfo(id);

        if(chat != null){
            List<String> users = Chat.getUsers(id);

            for(String user : users){
                userInfo.add(UserManager.getUser(user));
            }
            result.put("total", users.size());
            result.put("data", userInfo);
            return ResponseEntity.ok(result);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/private")
    public ResponseEntity<String> addChat(@RequestBody Map<String, Object> chat){

        if(chat.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(Chat.createChat((List<String>) chat.get("users")));
        }
    }

    @PostMapping("/api/group")
    public ResponseEntity<String> addGroupChat(@RequestBody Map<String, Object> chat){
        if(chat != null){
            return ResponseEntity.ok(Chat.createGroupChat((List<String>) chat.get("users"), (String) chat.get("name")));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/message")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, Object> message){
        if(message.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(Chat.sendMessage((String) message.get("text"), (String) message.get("senderId"),
                    (String) message.get("chatId")));
        }
    }

    @PostMapping("api/chat/user")
    public ResponseEntity<String> addUser(@RequestBody Map<String, Object> user){
        if(user != null){
            GroupChat.addUser((String) user.get("userId"), (String) user.get("chatId"));
            return ResponseEntity.ok("success");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("api/chat/user")
    public ResponseEntity<String> deleteUser(@RequestBody Map<String, Object> user){
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            GroupChat.deleteUser((String) user.get("userId"), (String) user.get("chatId"));
            return ResponseEntity.ok("success");
        }
    }


    @DeleteMapping("api/chat")
    public ResponseEntity<String> deleteChat(@RequestBody Map<String, Object> chat){
        if(chat.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            Chat.deleteChat((String) chat.get("chatId"));

            return ResponseEntity.ok("success");
        }
    }

    @PutMapping("api/chat")
    public ResponseEntity<String> editNameChat(@RequestBody Map<String, Object> chat){
        if(chat != null){
            GroupChat.setGroupName((String) chat.get("name"), (String) chat.get("id"));

            return ResponseEntity.ok("success");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
