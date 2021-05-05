import java.util.*;

class bookToreceive extends book
{
    private User User;
    private Date pickup_date_expired;
    private PIN bookToreceive_pin;
public bookToreceive(String idBook,String type,String author,String publisher,User user)
{
    super(idBook, type, author, publisher);
    this.user = user;

    this.bookToreceive_pin = PIN.generator_PIN();

    this.pickup_date_expired = new Date();

    Calendar c = Calendar.getInstance();
    
    this.pickup_date_expired = c.geTime();
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