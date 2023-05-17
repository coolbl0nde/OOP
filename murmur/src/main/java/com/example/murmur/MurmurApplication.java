package com.example.murmur;

import com.example.murmur.entities.Chat;
import com.example.murmur.entities.User;
import com.example.murmur.managers.ChatManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MurmurApplication {

    public static void main(String[] args) {

        SpringApplication.run(MurmurApplication.class, args);

        User user1 = new User("Masha", "Mihalevich", "+375294575445", "coolbl0nde", "364674537");
        User user2 = new User("Ilya", "Mihalevich", "+375295748934", "ilfkdg", "kkfjfdjglgjf");

        System.out.println("user1: " + user1.getId());
        System.out.println("user2: " + user2.getId());

        Chat chat = new Chat(user1.getId(), user2.getId());
        System.out.println("Создан чат 1 и 2 пользователя: " + chat.getId());

        System.out.println(ChatManager.sendMessage("hello", user1.getId(), chat.getId()));
    }

}
