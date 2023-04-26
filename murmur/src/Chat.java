import javax.swing.*;
import java.util.*;

public class Chat {

    private final int id;
    private final DataBase dataBase;
    static private DataBase staticDataBase;

    public Chat(int firstUser, int secondUser, DataBase dataBase){
        this.id = new Random().nextInt();

        staticDataBase = dataBase;
        this.dataBase = dataBase;
        dataBase.addChat(this.id, firstUser, secondUser);
    }

    public Chat(int firstUser, int secondUser, String name, DataBase dataBase){
        this.id = new Random().nextInt();

        this.dataBase = dataBase;
        dataBase.addGroupChat(this.id, firstUser, secondUser, name);
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
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if (chat.get("id").equals(this.id)) {
                List<Integer> updatedMessages = (List<Integer>)chat.get("messages");

                if(updatedMessages.contains(messageId)) {
                    updatedMessages.remove(Integer.valueOf(messageId));
                }
                break;
            }
        }

        List<Map<String, Object>> messages = dataBase.getMessagesList();

        for(Map<String, Object> message : messages){
            if (message.get("id").equals(this.id)) {
                messages.remove(message);

                break;
            }
        }
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

    static public void deleteChat(int chatId){
        List<Map<String, Object>> chats = staticDataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(chatId)){
               chats.remove(chat);
               break;
            }
        }
    }

    static public List<Integer> listOfChats(){
        List<Map<String, Object>> chats = staticDataBase.getChatList();
        List<Integer> chatsId = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            chatsId.add((Integer) chat.get("id"));
        }

        return chatsId;
    }

}
