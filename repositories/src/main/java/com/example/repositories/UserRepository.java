package com.example.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {

    public static Map<String, Object> getUserInfo(String userId) {
        RestTemplate restTemplate = new RestTemplate();

        String urlUser = "http://localhost:8080/api/user?id={id}";

        ResponseEntity<Map> responseUser = restTemplate.getForEntity(urlUser, Map.class, userId);

        return responseUser.getBody();
    }

    private static Map<String, Object> toUserDTO(Map<String, Object> user){
        List<String> contacts = (List<String>) user.get("contacts");
        List<Map<String, Object>> contactsInfo = new ArrayList<>();

        for (String contact : contacts){
            contactsInfo.add(UserRepository.getUserInfo(contact));
        }

        user.put("contacts", contactsInfo);

        return user;
    }
}
