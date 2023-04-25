import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GroupChat extends Chat{
    private int id;
    private DataBase dataBase;
    public GroupChat(int firstUser, int secondUser, String name, DataBase dataBase){
        super(firstUser, secondUser, name, dataBase);
        this.id = new Random().nextInt();

        this.dataBase = dataBase;
    }

    public void addUser(int userId){
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(this.id)){
                ((List<Integer>)chat.get("users")).add(userId);
                //List<Integer> updatedUsers = new ArrayList<>();
                //updatedUsers = (List<Integer>) chat.get("users");
                //updatedUsers.add(userId);
            }
        }
    }

    public void deleteUser(int userId){
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(this.id)){
                List<Integer> updatedUsers = (List<Integer>) chat.get("users");
                if(updatedUsers.contains(userId)) {
                    updatedUsers.remove(Integer.valueOf(userId));
                }
                break;
            }
        }
    }

    public String getGroupName(String name){
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(this.id)){
                return (String) chat.get("name");
            }
        }

        return null;
    }

    public void setGroupName(String name){
        List<Map<String, Object>> chats = dataBase.getChatList();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(this.id)){
                chat.put("name", name);
                break;
            }
        }
    }

    public List<String> getNameOfUsers(){
        List<Map<String, Object>> chats = dataBase.getChatList();
        List<String> nameOfUsers = new ArrayList<>();

        for(Map<String, Object> chat : chats){
            if(chat.get("id").equals(this.id)){
                List<Integer> users = (List<Integer>) chat.get("users");

                for(Integer userId : users){
                    nameOfUsers.add(User.getName(userId));
                }
            }
        }
        return nameOfUsers;
    }
}
