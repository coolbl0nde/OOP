package com.example.murmur.managers;
import com.example.murmur.entities.Message;
import com.example.murmur.entities.User;

import java.util.*;
public class ChatManager {
    private static DataBase dataBase = DataBase.getInstance();

    public ChatManager(){
    }

    public static void addChat(String id, String firstUser, String secondUser){
        List<String> idUsers = new ArrayList<>();
        idUsers.add(firstUser);
        idUsers.add(secondUser);

        List<String> idMessages = new ArrayList<>();

        Map<String, Object> chatData = new HashMap<>();
        chatData.put("id", id);
        chatData.put("users", idUsers);
        chatData.put("messages", idMessages);

        dataBase.insert(chatData, "chat");
    }

    public static void addGroupChat(String id, String firstUser, String secondUser, String name){
        List<String> idUsers = new ArrayList<>();
        idUsers.add(firstUser);
        idUsers.add(secondUser);

        List<String> idMessages = new ArrayList<>();

        Map<String, Object> chatData = new HashMap<>();
        chatData.put("id", id);
        chatData.put("users", idUsers);
        chatData.put("messages", idMessages);
        chatData.put("name", name);

        dataBase.insert(chatData, "chat");
    }

    public static void sendMessage(String text, String senderId, String chatId){
        Message message = new Message(text, senderId);
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(chatId)) {
                ((List<String>)chat.get("messages")).add(message.getId());
            }
        }
    }

    public static void deleteMessage(String messageId, String chatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(chatId)) {
                List<String> updatedMessages = (List<String>)chat.get("messages");

                if(updatedMessages.contains(messageId)) {
                    updatedMessages.remove(String.valueOf(messageId));
                }
                break;
            }
        }

        List<Map<String, Object>> messages = dataBase.get("message");

        for(Map<String, Object> message : messages){
            if (message.get("id").equals(chatId)) {
                messages.remove(message);

                break;
            }
        }
    }

    public static Map<String, String > messagesList(String chatId){
        List<Map<String, Object>> chats = dataBase.get("chat");
        Map<String, String> textOfMessages = new HashMap<>();

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(chatId)) {
                List<String> messages = (List<String>) chat.get("messages");

                for(String messageId : messages){
                    textOfMessages.put(Message.getSender(messageId), Message.getText(messageId));
                }
            }
        }

        return textOfMessages;
    }

    public static void deleteChat(String chatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(chatId)){
                chats.remove(chat);
                break;
            }
        }
    }
    public static List<String> listOfChats(){
        List<Map<String, Object>> chats = dataBase.get("chat");
        List<String> chatsId = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            chatsId.add((String) chat.get("id"));
        }

        return chatsId;
    }

    public static void addUser(String userId, String groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                ((List<String>)chat.get("users")).add(userId);
            }
        }
    }

    public static void deleteUser(String userId, String groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                List<Integer> updatedUsers = (List<Integer>) chat.get("users");
                if(updatedUsers.contains(userId)) {
                    updatedUsers.remove(Integer.valueOf(userId));
                }
                break;
            }
        }
    }

    public static String getGroupName(String groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                return (String) chat.get("name");
            }
        }

        return null;
    }

    public static void setGroupName(String name, String groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                chat.put("name", name);
                break;
            }
        }
    }

    public static List<String> getNameOfUsers(String groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");
        List<String> nameOfUsers = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                List<String> users = (List<String>) chat.get("users");

                for(String userId : users){
                    nameOfUsers.add(User.getName(userId));
                }
            }
        }
        return nameOfUsers;
    }

    public static Map<String, Object> getChatInfo(String id){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(id)){
                return chat;
            }
        }

        return null;
    }
}
