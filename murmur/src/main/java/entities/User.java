package entities;

import managers.UserManager;

import java.util.Random;

public class User {
    private int id;

    public User(String name, String surname, String phoneNumber, String username, String password) {
        this.id = new Random().nextInt();

        UserManager.addUser(this.id, name, surname, phoneNumber, username, password);

    }

    public int getId(){
        return this.id;
    }

    public static String getName(int id){
        return UserManager.getName(id);
    }

    public void setName(String name) {
        UserManager.setName(name, this.id);
    }

    public String getSurname() {
        return UserManager.getSurname(this.id);
    }

    public void setSurname(String surname) {
        UserManager.setSurname(surname, this.id);
    }

    public String getPhoneNumber() {
        return UserManager.getPhoneNumber(this.id);
    }

    public void setPhoneNumber(String phoneNumber) {
        UserManager.setPhoneNumber(phoneNumber, this.id);
    }

    public String getUsername() {
        return UserManager.getUsername(this.id);
    }

    public void setUsername(String username) {
        UserManager.setUsername(username, this.id);
    }

    public String getPassword() {
        return UserManager.getPassword(this.id);
    }

    public void setPassword(String password) {
        UserManager.setPassword(password, this.id);
    }
}