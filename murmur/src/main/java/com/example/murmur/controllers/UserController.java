package com.example.murmur.controllers;

import com.example.murmur.entities.User;
import com.example.murmur.managers.UserManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController()
public class UserController {

    @GetMapping("/api/user")
    public ResponseEntity<Map<String, Object>> getUser(@RequestParam String id){
        Map<String, Object> user = UserManager.getUser(id);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping("/api/contact")
    public ResponseEntity<String> addContact(@RequestBody Map<String, Object> contact){
        if(contact.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Map<String, Object> user = UserManager.findUser((String) contact.get("phoneNumber"));

            if (user != null) {
                UserManager.setContacts(user.get("_id").toString(), (String) contact.get("id"));

                return ResponseEntity.ok(user.get("_id").toString());
            }
            else {
                return ResponseEntity.notFound().build();
            }

        }
    }


}