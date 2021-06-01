import java.util.*;

class PIN
{
    private int PIN_number;
    private Date PIN_expire_date;

    public PIN() throws InvalidPin
    {
        Date d = new Date();
        this.PIN_number = ThreadLocalRandom.current().nextInt();
        
        this.PIN_expire_date= new Date();


        Calendar c = Calendar.getInstance();
    
        this.PIN_expire_date = c.geTime();

     if(d.compareTo(c)>0) {
          throw new InvalidPin("Your Pin is not valid");
        }
     else if(d.compareTo(c)<0) {
            System.out.println("You pin is valid");
        }  

      }
    

    public User getPINnumber(){
        return PIN_number;
    }

    public Date getPINexpireDate()
    {
        return PIN_expire_date;
    }

}