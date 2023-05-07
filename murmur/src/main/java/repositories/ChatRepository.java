package repositories;

import managers.ChatManager;
import managers.MessageManager;
import managers.UserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChatRepository {

    public Map<String, Object> getChatInfo(int id){
        Map<String, Object> chat = ChatManager.getChatInfo(id);
        List<Integer> users = (List<Integer>) chat.get("users");
        List<Map<String, Object>> userObjects = new ArrayList<>();

        for(Integer user : users){
            userObjects.add(UserManager.getUserInfo(user));
        }

        chat.put("users", userObjects);

        List<Integer> messages = (List<Integer>) chat.get("messages");
        List<Map<String, Object>> messageObjects = new ArrayList<>();

        for(Integer message : messages){
            messageObjects.add(MessageManager.getMessageInfo(message));
        }

        chat.put("messages", messageObjects);

        return chat;
    }
}
