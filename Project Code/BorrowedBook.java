import java.util.*;
import java.text.SimpleDateFormat;

public class BorrowedBook extends Book {

    private User user;
    private Date borrow_start_date, borrow_expire_date;

    public BorrowedBook(Book book, User user) {
        super(book.getTitle(), book.getCategory(), book.getAuthor(), book.getPublishingHouse(), book.getISBN(), book.getDetails(), book.getBook_copies());
        this.user = user;
        this.borrow_start_date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(borrow_start_date);
        c.add(Calendar.DATE, 15);
        this.borrow_expire_date = c.getTime();
    }

//    public String getIdBook(){
//        return idBook;
//    }

    public User getUser() {
        return user;
    }

    public Date getBorrowStartDate() {
        return borrow_start_date;
    }

    public Date getBorrowExpireDate() {
        return borrow_expire_date;
    }


    /*public void setIdBook(String idBook){
        this.idBook = idBook;
    }

    public void setUser(int user){
        this.user = user;
    }

    public void setBorrowStartDate(Date borrow_start_date){
        this.borrow_start_date = borrow_start_date;
    }

    public void setBorrowExpireDate(Date borrow_expire_date){
        this.borrow_expire_date = borrow_expire_date;
    }*/

    /* Συνάρτηση που επεκτείνει την ημερομηνία λήξης
    του δανεισμού ενός βιβλίου κατά έναν αριθμό ημερών. */

    public void expandExpireDate(int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(borrow_expire_date);
        c.add(Calendar.DAY_OF_MONTH, days);
        borrow_expire_date = c.getTime();
    }
}