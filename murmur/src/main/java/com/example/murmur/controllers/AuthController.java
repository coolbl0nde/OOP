package com.example.murmur.controllers;

import com.example.murmur.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody Map<String,String> user){
        //check

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return (ResponseEntity<String>) ResponseEntity.ok(User.createUser(user.get("name"), user.get("surname"),
                    user.get("phoneNumber"), user.get("username"), user.get("password")));
        }
    }

}
