package com.example.murmur;
import com.example.murmur.managers.UserManager;

import com.example.murmur.entities.Chat;
import com.example.murmur.entities.User;
import com.example.murmur.managers.ChatManager;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MurmurApplication {

    public static void main(String[] args) {

        SpringApplication.run(MurmurApplication.class, args);

    }

}
