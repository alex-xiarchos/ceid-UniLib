import java.security.SecureRandom;
import java.util.*;

public class PIN {
    private String PIN_number;
    private Date PIN_expire_date;

    public PIN()
    {
        this.PIN_number = getPIN();

        this.PIN_expire_date= new Date();

        Calendar c = Calendar.getInstance();

        this.PIN_expire_date = c.getTime();
    }

    public String getPINnumber(){
        return PIN_number;
    }

    public Date getPINexpireDate()
    {
        return PIN_expire_date;
    }


    public String getPIN()
    {
        String numbers = "1234567890";
        StringBuilder pin = new StringBuilder();
        SecureRandom srnd = new SecureRandom();
        while(pin.length() < 12)
        {
            int index = (int)(srnd.nextFloat() * numbers.length());
            pin.append(numbers.charAt(index));
        }

        String pinStr = pin.toString();
        return pinStr;
    }
}