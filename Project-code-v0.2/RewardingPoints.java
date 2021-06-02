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

    /* Συνάρτηση που υπολογίζει το πλήθος των ημερών επέκτασης που δικαιούται
    ο χρήστης βάσει των πόντων επιβράβευσής του. Ισχύει: 10 πόντοι = 1 ημέρα. */

    public int pointsToDays() {
        int days = points/10;
        return days;
    }
}