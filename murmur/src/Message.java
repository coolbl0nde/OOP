import java.text.SimpleDateFormat;
import java.util.*;

public class Message {
    private final int id;

    public Message(String text, int senderId){
        this.id = new Random().nextInt();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());

        MessageManager.addMessage(this.id, text, date, time, senderId);
    }

    public int getId(){
        return this.id;
    }

    public static String getSender(int id){
        return MessageManager.getSender(id);
    }

    public static String getText(int id){
        return MessageManager.getText(id);
    }

    public void setText(String text){
        MessageManager.setText(text, this.id);
    }

    public String getDate(){
        return MessageManager.getDate(this.id);
    }

    public String getTime(){
        return MessageManager.getTime(this.id);
    }
}
