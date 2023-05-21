package com.example.murmur.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static DataBase dataBase = DataBase.getInstance();


    public static String addUser(String name, String surname, String phoneNumber, String username, String password){

        Map<String, Object> userData = new HashMap<>();

        List<String> contacts = new ArrayList<>();

        userData.put("name", name);
        userData.put("surname", surname);
        userData.put("username", username);
        userData.put("phoneNumber", phoneNumber);
        userData.put("password", password);
        userData.put("contacts", contacts);

        String id = dataBase.insert(userData, "user");

        return id;
    }
    public static String getName(String id){
        String name = (String) dataBase.getFieldValue(id, "name", "user");

        return name;
    }

    public static void setName(String name, String id) {
        dataBase.update(id, "name", name, "user");
    }

    public static String getSurname(String id) {
        String surname = (String) dataBase.getFieldValue(id, "surname", "user");

        return surname;
    }

    public static void setSurname(String surname, String id) {
        dataBase.update(id, "surname", surname, "user");
    }

    public static String getPhoneNumber(String id) {
        String phoneNumber = (String) dataBase.getFieldValue(id, "phoneNumber", "user");

        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber, String id) {
        dataBase.update(id, "phoneNumber", phoneNumber, "user");
    }

    public static String getUsername(String id) {
        String name = (String) dataBase.getFieldValue(id, "username", "user");

        return name;
    }

    public static void setUsername(String username, String id) {
        dataBase.update(id, "username", username, "user");
    }

    public static String getPassword(String id) {
        String name = (String) dataBase.getFieldValue(id, "password", "user");

        return name;
    }

    public static void setPassword(String password, String id) {
        dataBase.update(id, "password", password, "user");
    }

    public static Map<String, Object> getUser(String id){
        Map<String, Object> user = dataBase.get(id, "user");

        return user;
    }

    public static List<String> getContacts(String id){
        List<String> contacts = (List<String>) dataBase.getFieldValue(id,"contacts", "user");

        return contacts;
    }

    public static void setContacts(String idContact, String id){
        List<String> contacts = (List<String>) dataBase.getFieldValue(id,"contacts", "user");

        contacts.add(idContact);

        dataBase.update(id, "contacts", contacts, "user");
    }

    public static Map<String, Object> findUser(String fieldName, String fieldValue){
        Map<String, Object> id = dataBase.getByFieldValue(fieldName, fieldValue, "user");

        return id;
    }
}
