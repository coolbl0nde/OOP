package com.example.murmur;

import com.example.murmur.entities.Chat;
import com.example.murmur.entities.GroupChat;
import com.example.murmur.entities.User;
import com.example.murmur.managers.DataBase;
import com.example.murmur.managers.UserManager;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();

        User user1 = new User("Masha", "Mihalevich", "+375294575445", "coolbl0nde", "364674537");
        User user2 = new User("Ilya", "Mihalevich", "+375295748934", "ilfkdg", "kkfjfdjglgjf");

        System.out.println("Данные первого пользователя: " + User.getName(user1.getId()) + " " + user1.getSurname() + " " + user1.getUsername() + " " + user1.getPhoneNumber());
        System.out.println("Данные второго пользователя: " + User.getName(user2.getId()) + " " + user2.getSurname());

        /*System.out.println("Меняем имя у 1 пользователя.");
        user1.setName("Lera");
        System.out.println("Новое имя: " + user1.getName());*/

        Chat chat = new Chat(user1.getId(), user2.getId());
        System.out.println("Создан чат 1 и 2 пользователя");
        chat.sendMessage("как дела", user1.getId());
        chat.sendMessage("норм", user2.getId());
        System.out.println("Список сообщений: " + chat.messagesList());

        GroupChat groupChat = new GroupChat(user1.getId(), user2.getId(), "group");
        groupChat.sendMessage("пока", user2.getId());

        User user3 = new User("Vlada", "Mihalevich", "+375295748949", "coolbl0nde", "364674537");

        System.out.println("id user1 = " + user1.getId() + " id user2 = " + user2.getId() + " id user3 = " + user3.getId());

        groupChat.addUser(user3.getId());

        System.out.println("Список пользователей в группе: " + groupChat.getNameOfUsers());

        groupChat.deleteUser(user1.getId());

        System.out.println("Список с удаленным пользователем: " + groupChat.getNameOfUsers());

        groupChat.sendMessage("привет всем", user2.getId());
        groupChat.sendMessage("приветики", user3.getId());
        System.out.println("Сообщения группового чата: " + groupChat.messagesList());

        System.out.println(UserManager.getUser(user1.getId()));

    }
}