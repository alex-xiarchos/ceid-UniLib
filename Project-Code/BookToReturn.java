import java.util.*;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

class BookToReturn extends Book
{
    private User user;
    private Date return_date;
    private PIN bookToreturn_pin;

    public BookToReturn(Book book, User user)
    {
        super(book.getTitle(), book.getCategory(), book.getAuthor(), book.getPublishingHouse(), book.getISBN(), book.getDetails(), book.getBook_copies());
        this.user = user;

        //this.bookToreturn_pin = PIN.generator_PIN();

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

    public PIN getBookToReturnPin()
    {
        return bookToreturn_pin;
    }
    /*
    public boolean cmpReturnWithCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        Date date = new Date();
        Date currdate = formatter.parse(toString(date));
        if (currdate.compareTo(return_date) == -1) {
            return false;
        }
        else return true;
    }
    */
}