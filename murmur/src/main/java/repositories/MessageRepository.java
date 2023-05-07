package repositories;

import managers.MessageManager;

import java.util.Map;

public class MessageRepository {

    public Map<String, Object> getMessageInfo(int id){
        return MessageManager.getMessageInfo(id);
    }
}
