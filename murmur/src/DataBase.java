import java.util.*;

public class DataBase {
    private List<Map<String, Object>> usersList;
    private List<Map<String, Object>> messagesList;
    private List<Map<String, Object>> chatList;
    private List<Map<String, Object>> groupChatList;

    public DataBase(){
        this.usersList = new ArrayList<>();
        this.messagesList = new ArrayList<>();
        this.chatList = new ArrayList<>();
        this.groupChatList = new ArrayList<>();
    }

    public void addUser(int id, String name, String surname, String phoneNumber, String username, String password) {
        Map<String, Object> userData = new HashMap<>();

        userData.put("id", id);
        userData.put("name", name);
        userData.put("surname", surname);
        userData.put("username", username);
        userData.put("phoneNumber", phoneNumber);
        userData.put("password", password);

        this.usersList.add(userData);
    }
    public void addMessage(int id, String text, String date, String time, int senderId){
        Map<String, Object> messageData = new HashMap<>();

        messageData.put("id", id);
        messageData.put("text", text);
        messageData.put("date", date);
        messageData.put("time", time);
        messageData.put("sender", senderId);

        this.messagesList.add(messageData);
    }
    public void addChat(int id, int firstUser, int secondUser){
        List<Integer> idUsers = new ArrayList<>();
        idUsers.add(firstUser);
        idUsers.add(secondUser);

        List<Integer> idMessages = new ArrayList<>();

        Map<String, Object> chatData = new HashMap<>();
        chatData.put("id", id);
        chatData.put("users", idUsers);
        chatData.put("messages", idMessages);

        this.chatList.add(chatData);
    }

    public void addGroupChat(int id, int firstUser, int secondUser, String name){
        List<Integer> idUsers = new ArrayList<>();
        idUsers.add(firstUser);
        idUsers.add(secondUser);

        List<Integer> idMessages = new ArrayList<>();

        Map<String, Object> chatData = new HashMap<>();
        chatData.put("id", id);
        chatData.put("users", idUsers);
        chatData.put("messages", idMessages);
        chatData.put("name", name);

        //this.groupChatList.add(chatData);
        this.chatList.add(chatData);
    }
    public List<Map<String, Object>> getUsersList(){
        return this.usersList;
    }
    public List<Map<String, Object>> getMessagesList(){
        return this.messagesList;
    }
    public List<Map<String, Object>> getChatList(){
        return this.chatList;
    }
    public List<Map<String, Object>> getGroupChatList(){
        return this.chatList;
    }
}
