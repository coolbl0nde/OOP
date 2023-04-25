import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Message {
    private int id;
    private Map<String, Object> messageData;
    private DataBase dataBase;
    static DataBase staticDataBase;

    public Message(String text, int senderId, DataBase dataBase){
        this.id = new Random().nextInt();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        staticDataBase = dataBase;
        this.dataBase = dataBase;
        dataBase.addMessage(this.id, text, date, time, senderId);
    }

    public int getId(){
        return this.id;
    }

    static public String getSender(int messageId){
        List<Map<String, Object>> messageList = staticDataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(messageId)){
                int senderId = (Integer) message.get("sender");
                return (String)User.getName(senderId);
            }
        }

        return null;
    }

    public int getSender(){
        List<Map<String, Object>> messageList = dataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(this.id)){
                int senderId = (Integer) message.get("sender");
                return (Integer) message.get("sender");
            }
        }

        return 0;
    }

    public String getText(){
        List<Map<String, Object>> messageList = dataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(this.id)){
                return (String) message.get("text");
            }
        }

        return null;
    }

    static public String getText(int messageId){
        List<Map<String, Object>> messageList = staticDataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(messageId)){
                return (String) message.get("text");
            }
        }

        return null;
    }

    public void setText(String text){
        List<Map<String, Object>> messageList = dataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(this.id)){
                message.put("text", text);
                break;
            }
        }
    }

    public String getDate(){
        List<Map<String, Object>> messageList = dataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(this.id)){
                return (String) message.get("date");
            }
        }

        return null;
    }

    public String getTime(){
        List<Map<String, Object>> messageList = dataBase.getMessagesList();

        for(Map<String, Object> message : messageList){
            if(message.get("id").equals(this.id)){
                return (String) message.get("time");
            }
        }

        return null;
    }
}
