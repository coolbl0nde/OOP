import java.util.*;

public class Chat {

    protected final int id;

    public Chat(int firstUser, int secondUser){
        this.id = new Random().nextInt();

        ChatManager.addChat(this.id, firstUser, secondUser);
    }

    public Chat(int firstUser, int secondUser, String name){
        this.id = new Random().nextInt();

        ChatManager.addGroupChat(id, firstUser, secondUser, name);
    }

    public int getId(){
        return this.id;
    }

    public void sendMessage(String text, int senderId){
        ChatManager.sendMessage(text, senderId, this.id);
    }

    public void deleteMessage(int messageId){
        ChatManager.deleteMessage(messageId, this.id);
    }

    public Map<String, String > messagesList(){
        return ChatManager.messagesList(this.id);
    }

    public static void deleteChat(int chatId){
        ChatManager.deleteChat(chatId);
    }

    public static List<Integer> listOfChats(){
        return ChatManager.listOfChats();
    }

}
