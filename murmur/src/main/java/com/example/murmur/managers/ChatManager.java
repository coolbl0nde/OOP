package com.example.murmur.managers;
import com.example.murmur.entities.Message;
import com.example.murmur.entities.User;

import java.util.*;
public class ChatManager {
    private static DataBase dataBase = DataBase.getInstance();

    public ChatManager(){
    }

    public static void addChat(int id, int firstUser, int secondUser){
        List<Integer> idUsers = new ArrayList<>();
        idUsers.add(firstUser);
        idUsers.add(secondUser);

        List<Integer> idMessages = new ArrayList<>();

        Map<String, Object> chatData = new HashMap<>();
        chatData.put("id", id);
        chatData.put("users", idUsers);
        chatData.put("messages", idMessages);

        dataBase.insert(chatData, "chat");
    }

    public static void addGroupChat(int id, int firstUser, int secondUser, String name){
        List<Integer> idUsers = new ArrayList<>();
        idUsers.add(firstUser);
        idUsers.add(secondUser);

        List<Integer> idMessages = new ArrayList<>();

        Map<String, Object> chatData = new HashMap<>();
        chatData.put("id", id);
        chatData.put("users", idUsers);
        chatData.put("messages", idMessages);
        chatData.put("name", name);

        dataBase.insert(chatData, "chat");
    }

    public static void sendMessage(String text, int senderId, int chatId){
        Message message = new Message(text, senderId);
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(chatId)) {
                ((List<Integer>)chat.get("messages")).add(message.getId());
            }
        }
    }

    public static void deleteMessage(int messageId, int chatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(chatId)) {
                List<Integer> updatedMessages = (List<Integer>)chat.get("messages");

                if(updatedMessages.contains(messageId)) {
                    updatedMessages.remove(Integer.valueOf(messageId));
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

    public static Map<String, String > messagesList(int chatId){
        List<Map<String, Object>> chats = dataBase.get("chat");
        Map<String, String> textOfMessages = new HashMap<>();

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(chatId)) {
                List<Integer> messages = (List<Integer>) chat.get("messages");

                for(Integer messageId : messages){
                    textOfMessages.put(Message.getSender(messageId), Message.getText(messageId));
                }
            }
        }

        return textOfMessages;
    }

    public static void deleteChat(int chatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(chatId)){
                chats.remove(chat);
                break;
            }
        }
    }
    public static List<Integer> listOfChats(){
        List<Map<String, Object>> chats = dataBase.get("chat");
        List<Integer> chatsId = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            chatsId.add((Integer) chat.get("id"));
        }

        return chatsId;
    }

    public static void addUser(int userId, int groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                ((List<Integer>)chat.get("users")).add(userId);
            }
        }
    }

    public static void deleteUser(int userId, int groupChatId){
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

    public static String getGroupName(int groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                return (String) chat.get("name");
            }
        }

        return null;
    }

    public static void setGroupName(String name, int groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                chat.put("name", name);
                break;
            }
        }
    }

    public static List<String> getNameOfUsers(int groupChatId){
        List<Map<String, Object>> chats = dataBase.get("chat");
        List<String> nameOfUsers = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(groupChatId)){
                List<Integer> users = (List<Integer>) chat.get("users");

                for(Integer userId : users){
                    nameOfUsers.add(User.getName(userId));
                }
            }
        }
        return nameOfUsers;
    }

    public static Map<String, Object> getChatInfo(int id){
        List<Map<String, Object>> chats = dataBase.get("chat");

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(id)){
                return chat;
            }
        }

        return null;
    }
}
