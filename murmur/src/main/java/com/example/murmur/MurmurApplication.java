package com.example.murmur;
import com.example.murmur.managers.UserManager;
import com.example.repositories.UserRepository;

import com.example.repositories.MessageRepository;
import com.example.murmur.entities.Chat;
import com.example.murmur.entities.User;
import com.example.murmur.managers.ChatManager;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MurmurApplication {

    public static void main(String[] args) {

        SpringApplication.run(MurmurApplication.class, args);

        /*String user1 = User.createUser("Masha", "Mihalevich", "+375294575445", "coolbl0nde", "364674537");
        String user2 = User.createUser("Ilya", "Mihalevich", "+375295748934", "ilfkdg", "kkfjfdjglgjf");

        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);

        List<String> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);

        String chat = Chat.createChat(users);
        System.out.println("Создан чат 1 и 2 пользователя: " + chat);

        System.out.println("message1: " + ChatManager.sendMessage("hello", user1, chat));
        System.out.println("message2: " + ChatManager.sendMessage("bye", user2, chat));

        System.out.println("messages: " + ChatManager.messagesList(chat));
        System.out.println("name user1: " + UserManager.getName(user1));*/

        //ChatManager.deleteMessage("64691c29a8c253541d6dff4c", "64691c29a8c253541d6dff4b");

        System.out.println(UserManager.findUser("+375294575445"));
    }

}
