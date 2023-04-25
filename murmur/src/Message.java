import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Message {
    private int id;
    private Map<String, Object> messageData;
    DataBase dataBase;

    public Message(String text, int senderId, DataBase dataBase){
        this.id = new Random().nextInt();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        this.dataBase = dataBase;
        dataBase.addMessage(this.id, text, date, time, senderId);
    }

    public int getId(){
        return this.id;
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
