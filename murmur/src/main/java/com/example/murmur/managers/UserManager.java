package com.example.murmur.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static DataBase dataBase = DataBase.getInstance();


    public static String addUser(String id, String name, String surname, String phoneNumber, String username, String password){
        Map<String, Object> userData = new HashMap<>();

        List<String> contacts = new ArrayList<>();

        userData.put("id", id);
        userData.put("name", name);
        userData.put("surname", surname);
        userData.put("username", username);
        userData.put("phoneNumber", phoneNumber);
        userData.put("password", password);
        userData.put("contacts", contacts);

        dataBase.insert(userData, "user");

        return id;
    }
    public static String getName(String id){
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("name");
            }
        }

        return null;
    }

    public static void setName(String name, String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("name", name);
                break;
            }
        }
    }

    public static String getSurname(String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("surname");
            }
        }

        return null;
    }

    public static void setSurname(String surname, String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("surname", surname);
                break;
            }
        }
    }

    public static String getPhoneNumber(String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("phoneNumber");
            }
        }

        return null;
    }

    public static void setPhoneNumber(String phoneNumber, String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("phoneNumber", phoneNumber);
                break;
            }
        }
    }

    public static String getUsername(String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("username");
            }
        }

        return null;
    }

    public static void setUsername(String username, String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("username", username);
                break;
            }
        }
    }

    public static String getPassword(String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                return (String)user.get("password");
            }
        }

        return null;
    }

    public static void setPassword(String password, String id) {
        List<Map<String, Object>> userList = dataBase.get("user");

        for (Map<String, Object> user : userList) {
            if (user.get("id").equals(id)) {
                user.put("password", password);
                break;
            }
        }
    }

    public static Map<String, Object> getUser(String id){
        List<Map<String, Object>> users = dataBase.get("user");

        for(Map<String, Object> user : users){
            if(user.get("id").equals(id)){
                return user;
            }
        }

        return null;
    }

    public static List<Integer> getContacts(String id){
        List<Map<String, Object>> users = dataBase.get("user");

        for(Map<String, Object> user : users){
            if (user.get("id").equals(id)) {
                return (List<Integer>) user.get("contacts");
            }
        }

        return null;
    }

    public static void setContacts(String idContact, String id){
        List<Map<String, Object>> users = dataBase.get("user");

        for(Map<String, Object> user : users){
            if (user.get("id").equals(id)) {
                ((List<String>)user.get("contacts")).add(idContact);
            }
        }
    }

    public static String findUser(String phoneNumber){
        List<Map<String, Object>> users = dataBase.get("user");

        for(Map<String, Object> user : users){
            if(user.get("phoneNumber").equals(phoneNumber)){
                return (String) user.get("id");
            }
        }

        return null;
    }
}
