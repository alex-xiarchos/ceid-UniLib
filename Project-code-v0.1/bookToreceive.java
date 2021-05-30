import java.util.*;

class BookToReceive extends Book
{
    private User user;
    private Date pickup_date_expired;
    private PIN bookToreceive_pin;

    public BookToReceive(String title, String category, String author, String publishing_house, String ISBN, String details, User user)
    {
        super(title, category, author, publishing_house, ISBN, details);
        this.user = user;

        this.bookToreceive_pin = PIN.generator_PIN();

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

        public int getBookToReceivePin()
        {
            return bookToreceive_pin;
        }

        public String getDetails()
        {
            return("\nUser name: " +this.user.getuName()+"\nPIN: " +this.bookToreceive_pin + "\nPickup Date Expired: "+this.pickup_date_expired); 
        }

}