package com.example.murmur.controllers;

import com.example.murmur.entities.User;
import com.example.murmur.managers.UserManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController()
public class UserController {

    @GetMapping("/api/user")
    public Map<String, Object> getUser(@RequestParam String id){
        return UserManager.getUser(id);
    }

    @PostMapping("/api/contact")
    public ResponseEntity<String> addContact(@RequestBody Map<String, Object> contact){
        if(contact.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            String idContact = UserManager.findUser((String) contact.get("phoneNumber"));
            System.out.println(idContact);
            if (!idContact.isEmpty()) {
                UserManager.setContacts(idContact, (String) contact.get("id"));

                return ResponseEntity.ok(idContact);
            }
            else {
                return ResponseEntity.notFound().build();
            }

        }
    }


}

//-1801874612


//-1119237505 +375295835934