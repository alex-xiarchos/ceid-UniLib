import java.util.*;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

class BookToReturn extends Book
{
    private User User;
    private Date return_date;
    private PIN bookToreturn_pin;

    public bookToreturn(String idBook,String type,String author,String publisher,User user)
    {
        super(idBook, type, author, publisher);
        this.user = user;

        this.bookToreturn_pin = PIN.generator_PIN();

        this.return_date = new Date();

        Calendar c = Calendar.getInstance();
        
        this.return_date = c.getTime();
    }

    public User getUser(){
        return user;
    }

    public Date getReturnDate()
    {
            return return_date;
    }

    public int getBookToReturnPin()
    {
        return bookToreturn_pin;
    }

    public boolean cmpReturnWithCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        Date date = new Date();
        Date currdate = formatter.parse(date);
        if (currdate.compareTo(return_date) == -1) {
            return false;
        }
        else return true;
    }

    public String getDetails()
    {
        return("\nUser name: " +this.user.getuName()+"\nPIN: " +this.bookToreturn_pin + "\nReturn Date: "+this.return_date); 
    }
}