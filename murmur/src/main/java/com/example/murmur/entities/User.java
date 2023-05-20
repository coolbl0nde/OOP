package com.example.murmur.entities;

import com.example.murmur.managers.UserManager;

import java.util.List;

public class User {

    public static String createUser(String name, String surname, String phoneNumber, String username, String password) {
        String id = UserManager.addUser(name, surname, phoneNumber, username, password);

        return id;
    }

    public static String getName(String id){
        return UserManager.getName(id);
    }

    public void setName(String name, String id) {
        UserManager.setName(name, id);
    }

    public String getSurname(String id) {
        return UserManager.getSurname(id);
    }

    public void setSurname(String surname, String id) {
        UserManager.setSurname(surname, id);
    }

    public String getPhoneNumber(String id) {
        return UserManager.getPhoneNumber(id);
    }

    public void setPhoneNumber(String phoneNumber, String id) {
        UserManager.setPhoneNumber(phoneNumber, id);
    }

    public String getUsername(String id) {
        return UserManager.getUsername(id);
    }

    public void setUsername(String username, String id) {
        UserManager.setUsername(username, id);
    }

    public String getPassword(String id) {
        return UserManager.getPassword(id);
    }

    public void setPassword(String password, String id) {
        UserManager.setPassword(password, id);
    }

    public List<String> getContacts(String id){ return UserManager.getContacts(id); }

    public void setContacts(String idContact, String id){ UserManager.setContacts(idContact, id); }
}