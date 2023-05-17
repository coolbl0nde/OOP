package com.example.repositories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class UserRepository {

    public static Map<String, Object> getUserInfo(String userId) {
        RestTemplate restTemplate = new RestTemplate();

        String urlUser = "http://localhost:8080/api/user?id={id}";

        ResponseEntity<Map> responseUser = restTemplate.getForEntity(urlUser, Map.class, userId);

        return responseUser.getBody();
    }
}
