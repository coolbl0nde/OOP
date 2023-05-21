package com.example.murmur.controllers;

import com.example.murmur.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class UserController {

    @GetMapping("/api/user")
    public ResponseEntity<Map<String, Object>> getUser(@RequestParam String id){
        Map<String, Object> user = User.getUser(id);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(user);
        }
    }

    @GetMapping("/api/contact")
    public ResponseEntity<Map<String, Object>> listContact(@RequestParam String id){
        Map<String, Object> user = User.getUser(id);
        List<Map<String, Object>> contactsInfo = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();

        if(user != null){
            List<String> contacts = User.getContacts(id);
            Integer size = contacts.size();

            for(String contact : contacts){
                contactsInfo.add(User.getUser(contact));
            }
            result.put("total", size);
            result.put("data", contactsInfo);

            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/contact")
    public ResponseEntity<String> addContact(@RequestBody Map<String, Object> contact){
        if(contact.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Map<String, Object> user = User.findUser("phoneNumber", (String) contact.get("phoneNumber"));

            if (user != null) {
                User.setContacts(user.get("_id").toString(), (String) contact.get("id"));

                return ResponseEntity.ok(user.get("_id").toString());
            }
            else {
                return ResponseEntity.notFound().build();
            }

        }
    }

    @PutMapping("api/user")
    public ResponseEntity<String> editProfile(@RequestBody Map<String, Object> user){
        if(user != null){

            if(user.get("fieldName").equals("name")){
                System.out.println("1");
                User.setName((String) user.get("newValue"), (String) user.get("id"));
            } else if(user.get("fieldName").equals("name")){
                User.setSurname((String) user.get("newValue"), (String) user.get("id"));
            }else if(user.get("fieldName").equals("username")){
                Map<String, Object> userExist = User.findUser("username", (String) user.get("newValue"));

                if(userExist != null){
                    return ResponseEntity.internalServerError().body("User with this username already exists");
                }

                User.setUsername((String) user.get("newValue"), (String) user.get("id"));

            }else{
                return ResponseEntity.internalServerError().body("Incorrect fieldName");
            }

            return ResponseEntity.ok("success");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}