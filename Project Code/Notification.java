
public class Notification {

    public String sender;
    public String receiver;
    public String message;
    public String send_date;

    public String get_sender() {
        return sender;
    }

    public void set_sender(String sender) {
        this.sender = sender;
    }

    public String get_receiver() {
        return receiver;
    }

    public void set_receiver(String receiver) {
        this.receiver = receiver;
    }

    public String get_message() {
        return message;
    }

    public String get_send_date() {
        return send_date;
    }


}