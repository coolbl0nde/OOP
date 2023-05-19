package com.example.repositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoriesApplication.class, args);

		System.out.println("ChatInfo: " + ChatRepository.getChatInfo("-1524202938"));
		System.out.println("MessageInfo" + MessageRepository.getMessageInfo("-1226934877"));
		System.out.println("Chat Message: " + ChatRepository.chatMessages("-1524202938"));

		System.out.println("User: " + UserRepository.getUserInfo("-470048079"));
	}

}
