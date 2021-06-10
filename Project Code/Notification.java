import java.util.*;

public class Notification {

    private String sender;
    private String receiver;
    private String message;
    private Date send_date;

    public Notification(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        send_date = new Date();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public Date getSendDate() {
        return send_date;
    }


}