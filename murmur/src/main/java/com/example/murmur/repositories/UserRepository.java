package com.example.murmur.repositories;

import com.example.murmur.managers.UserManager;

import java.util.Map;

public class UserRepository {

    public Map<String,Object> getUserInfo(String id){
        return UserManager.getUser(id);
    }
}
