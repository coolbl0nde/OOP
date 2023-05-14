package com.example.murmur.controllers;

import com.example.murmur.entities.User;

import com.example.murmur.managers.UserManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> getUser(@RequestParam Integer id){
        return UserManager.getUser(id);
    }

    @PostMapping("/useradd")
    public void getUser(@RequestBody User user){

        UserManager.addUser(user.getId(), User.getName(user.getId()), user.getSurname(), user.getUsername(), user.getPassword(), user.getPhoneNumber());
    }

}
