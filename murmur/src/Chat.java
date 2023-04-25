import javax.swing.*;
import java.util.*;

public class Chat {

    private int id;
    private DataBase dataBase;

    public Chat(int firstUser, int secondUser, DataBase dataBase){
        this.id = new Random().nextInt();

        this.dataBase = dataBase;
        dataBase.addChat(this.id, firstUser, secondUser);
    }

    public int getId(){
        return this.id;
    }

    public void sendMessage(String text, int senderId, DataBase dataBase){
        Message message = new Message(text, senderId, dataBase);
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(this.id)) {
                ((List<Integer>)chat.get("messages")).add(message.getId());
            }
        }
    }

    public void deleteMessage(int messageId){

    }

    public Map<String, String > messagesList(){
        List<Map<String, Object>> chats = dataBase.getChatList();
        Map<String, String> textOfMessages = new HashMap<>();

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(this.id)) {
                 List<Integer> messages = (List<Integer>) chat.get("messages");

                 for(Integer messageId : messages){
                     textOfMessages.put(Message.getSender(messageId), Message.getText(messageId));
                 }
            }
        }

        return textOfMessages;
    }

    public void deleteChat(int chatId){
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(chatId)){
               chats.remove(chat);
               break;
            }
        }
    }

    public List<Integer> listOfChats(){
        List<Map<String, Object>> chats = dataBase.getChatList();
        List<Integer> chatsId = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            chatsId.add((Integer) chat.get("id"));
        }

        return chatsId;
    }

}
