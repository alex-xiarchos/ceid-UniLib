import java.util.*;

public class BookToReceive extends Book {
    private UserAccount user;
    private Date pickup_date_expired;
    private PIN bookToreceive_pin;

    public BookToReceive(Book book, UserAccount user) {
        super(book.getTitle(), book.getCategory(), book.getAuthor(), book.getPublishingHouse(), book.getISBN(), book.getDetails(), book.getBook_copies());
        this.user = user;
        this.bookToreceive_pin = new PIN();

        // Αυτόματος ορισμός ημερομηνίας λήξης παραλαβής του βιβλίου 7 μέρες μετά.
        pickup_date_expired = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(pickup_date_expired);
        c.add(Calendar.DATE, 7);
        this.pickup_date_expired = c.getTime();
    }

    public UserAccount getUser() {
        return user;
    }

    public Date getPickupDateExpired() {
        return pickup_date_expired;
    }

    public PIN getBookToReceivePin() {
        return bookToreceive_pin;
    }
}