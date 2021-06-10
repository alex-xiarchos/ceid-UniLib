import java.util.*;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class BookToReturn extends Book {
    private UserAccount user;
    private Date return_date;
    private PIN bookToreturn_pin;

    public BookToReturn(Book book, UserAccount user) {
        super(book.getTitle(), book.getCategory(), book.getAuthor(), book.getPublishingHouse(), book.getISBN(), book.getDetails(), book.getBook_copies());
        this.user = user;
        this.bookToreturn_pin = new PIN();
        this.return_date = new Date();

        // Αυτόματος ορισμός ημερομηνίας λήξης επιστροφής του βιβλίου 15 μέρες μετά το ξεκίνημα του δανεισμού.
        Calendar c = Calendar.getInstance();
        c.setTime(return_date);
        c.add(Calendar.DATE, 15);
        this.return_date = c.getTime();
    }

    public UserAccount getUser(){
        return user;
    }

    public Date getReturnDate() {
            return return_date;
    }

    public PIN getBookToReturnPin() {
        return bookToreturn_pin;
    }

    public boolean cmpReturnWithCurrentDate() {
        Date currdate = new Date();
        Calendar c = Calendar.getInstance();
        currdate = c.getTime();
        if (currdate.compareTo(return_date) == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}