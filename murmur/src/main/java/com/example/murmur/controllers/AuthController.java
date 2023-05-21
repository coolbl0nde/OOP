package com.example.murmur.controllers;

import com.example.murmur.entities.User;
import com.example.murmur.managers.UserManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

@RestController
public class AuthController {

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> user){
        String regex = "\\+\\d{7,12}";

        if (user != null) {
            Map<String, Object> phoneNumber = UserManager.findUser(user.get("phoneNumber"));
            Map<String, Object> username = UserManager.findUser(user.get("username"));

            if(!user.get("phoneNumber").matches(regex)){
                return ResponseEntity.internalServerError().body("Incorrect phone number");
            }

            if(phoneNumber != null){
                return ResponseEntity.internalServerError().body("User with this phone number already exists");
            }else if(username != null){
                return ResponseEntity.internalServerError().body("User with this username already exists");
            }else{
                String hashedPassword = BCrypt.hashpw(user.get("password"), BCrypt.gensalt());

                return (ResponseEntity<String>) ResponseEntity.ok(User.createUser(user.get("name"), user.get("surname"),
                        user.get("phoneNumber"), user.get("username"), hashedPassword));
            }
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("api/auth")
    public ResponseEntity<String> auth(@RequestBody Map<String, Object> user){

        if(user != null){
            Map<String, Object> userExist = UserManager.findUser((String) user.get("phoneNumber"));

            if(userExist != null && userExist.get("username").equals(user.get("username"))){

                if(BCrypt.checkpw((String) user.get("password"), (String) userExist.get("password"))){
                    return ResponseEntity.ok("success");
                }else{
                    return ResponseEntity.internalServerError().body("Incorrect password");
                }
            }else{
                return ResponseEntity.internalServerError().body("Incorrect username or phone number");
            }
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
