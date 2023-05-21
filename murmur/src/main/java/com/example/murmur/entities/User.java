package com.example.murmur.entities;

import com.example.murmur.managers.UserManager;

import java.util.List;
import java.util.Map;

public class User {

    public static String createUser(String name, String surname, String phoneNumber, String username, String password) {
        String id = UserManager.addUser(name, surname, phoneNumber, username, password);

        return id;
    }

    public static String getName(String id){
        return UserManager.getName(id);
    }

    public static void setName(String name, String id) {
        UserManager.setName(name, id);
    }

    public static String getSurname(String id) {
        return UserManager.getSurname(id);
    }

    public static void setSurname(String surname, String id) {
        UserManager.setSurname(surname, id);
    }

    public static String getPhoneNumber(String id) {
        return UserManager.getPhoneNumber(id);
    }

    public static void setPhoneNumber(String phoneNumber, String id) {
        UserManager.setPhoneNumber(phoneNumber, id);
    }

    public static String getUsername(String id) {
        return UserManager.getUsername(id);
    }

    public static void setUsername(String username, String id) {
        UserManager.setUsername(username, id);
    }

    public static String getPassword(String id) {
        return UserManager.getPassword(id);
    }

    public static void setPassword(String password, String id) {
        UserManager.setPassword(password, id);
    }

    public static List<String> getContacts(String id){ return UserManager.getContacts(id); }

    public static void setContacts(String idContact, String id){ UserManager.setContacts(idContact, id); }

    public static Map<String, Object> getUser(String id){ return UserManager.getUser(id); }

    public static Map<String, Object> findUser(String fieldName, String fieldValue){ return UserManager.findUser(fieldName, fieldValue); }
}