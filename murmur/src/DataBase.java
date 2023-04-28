import java.util.*;

public class DataBase {
    private List<Map<String, Object>> usersList;
    private List<Map<String, Object>> messagesList;
    private List<Map<String, Object>> chatList;
    private static DataBase INSTANCE;

    private DataBase(){
        this.usersList = new ArrayList<>();
        this.messagesList = new ArrayList<>();
        this.chatList = new ArrayList<>();
    }

    public static DataBase getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataBase();
        }

        return INSTANCE;
    }

    public void insert(Map<String, Object> data, String list) {
        if (list.equals("user")) {
            this.usersList.add(data);
        } else if (list.equals("message")) {
            this.messagesList.add(data);
        } else {
            this.chatList.add(data);
        }
    }

    public List<Map<String, Object>> get(String list) {
        if (list.equals("user")) {
            return this.usersList;
        } else if (list.equals("message")) {
            return this.messagesList;
        } else {
            return this.chatList;
        }
    }
}
