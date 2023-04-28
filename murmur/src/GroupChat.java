import java.util.List;
import java.util.Random;

public class GroupChat extends Chat{
    public GroupChat(int firstUser, int secondUser, String name){
        super(firstUser, secondUser, name);
    }

    public void addUser(int userId){
        ChatManager.addUser(userId, this.id);
    }

    public void deleteUser(int userId){
        ChatManager.deleteUser(userId, this.id);
    }

    public String getGroupName(){
        return ChatManager.getGroupName(this.id);
    }

    public void setGroupName(String name){
        ChatManager.setGroupName(name, this.id);
    }

    public List<String> getNameOfUsers(){
        return ChatManager.getNameOfUsers(this.id);
    }
}
