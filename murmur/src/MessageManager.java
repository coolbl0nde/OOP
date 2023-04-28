import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageManager {
    private static DataBase dataBase = DataBase.getInstance();

    public MessageManager(){
    }

    public static void addMessage(int id, String text, String date, String time, int senderId){
        Map<String, Object> messageData = new HashMap<>();

        messageData.put("id", id);
        messageData.put("text", text);
        messageData.put("date", date);
        messageData.put("time", time);
        messageData.put("sender", senderId);

        dataBase.insert(messageData,"message");
    }

    public static String getSender(int id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                int senderId = (Integer) message.get("sender");
                return (String)User.getName(senderId);
            }
        }

        return null;
    }
    public static String getText(int id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                return (String) message.get("text");
            }
        }

        return null;
    }

    public static void setText(String text, int id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                message.put("text", text);
                break;
            }
        }
    }

    public static String getDate(int id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                return (String) message.get("date");
            }
        }

        return null;
    }

    public static String getTime(int id){
        List<Map<String, Object>> messageList = dataBase.get("message");

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(id)){
                return (String) message.get("time");
            }
        }

        return null;
    }
}
