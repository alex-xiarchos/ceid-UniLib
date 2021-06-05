import java.util.*;

class BookToReceive extends Book
{
    private User user;
    private Date pickup_date_expired;
    private PIN bookToreceive_pin;

    public BookToReceive(Book book, User user)
    {
        super(book.getTitle(), book.getCategory(), book.getAuthor(), book.getPublishingHouse(), book.getISBN(), book.getDetails(), book.getBook_copies());
        this.user = user;

        //this.bookToreceive_pin = PIN.generator_PIN();

        this.pickup_date_expired = new Date();

        Calendar c = Calendar.getInstance();
        
        this.pickup_date_expired = c.getTime();
    }

        public User getUser(){
            return user;
        }

        public Date getPickupDateExpired()
        {
            return pickup_date_expired;
        }

        public PIN getBookToReceivePin()
        {
            return bookToreceive_pin;
        }

}