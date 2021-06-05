import java.util.*;
import java.util.concurrent.TimeUnit;

public class RewardingPoints {
    private int points;
    private int allpoints;

    public RewardingPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int RenewedPoints) {
        points = RenewedPoints;
    }

    public void addPoints(int newpoints){
        points += newpoints;
    }

    //Προσθήκη ή αφαίρεση πόντων ανάλογα με την σύγκριση ημερομηνίας επιστροφής και ημερομηνίας λήξης του δανεισμού
    //Θα χρειαστεί μάλλον με κάποιον τρόπο να γίνεται η σύνδεση points με Αccount.
    public void addremPoints(BookToReturn book){
        Date now = new Date();
        long diff = TimeUnit.MILLISECONDS.toDays(now.getTime() - book.getReturnDate().getTime());
        
        this.points = this.points + (int)diff/10;   //Δεν ήξερα ακριβώς με ποιον τρόπο είπαμε να υπολογίζουμε τους πόντους.
    }

    /* Συνάρτηση που υπολογίζει το πλήθος των ημερών επέκτασης που δικαιούται
    ο χρήστης βάσει των πόντων επιβράβευσής του. Ισχύει: 10 πόντοι = 1 ημέρα. */

    public int pointsToDays() {
        int days = points/10;
        return days;
    }
}