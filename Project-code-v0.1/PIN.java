import java.util.*;

class PIN
{
    private int PIN_number;
    private Date PIN_expire_date;

    public PIN()
    {
        this.PIN_number = ThreadLocalRandom.current().nextInt();
        
        this.PIN_expire_date= new Date();

        Calendar c = Calendar.getInstance();
    
        this.PIN_expire_date = c.geTime();
    }

    public User getPINnumber(){
        return PIN_number;
    }

    public Date getPINexpireDate()
    {
        return PIN_expire_date;
    }

}