public class RewardsPoints {
    private int points;

    public RewardsPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int RenewedPoints) {
        points = RenewedPoints;
    }

    /* Συνάρτηση που υπολογίζει το πλήθος των ημερών επέκτασης που δικαιούται
    ο χρήστης βάσει των πόντων επιβράβευσής του. Ισχύει: 10 πόντοι = 1 ημέρα. */

    public int pointsToDays(int mypoints) {
        int days = mypoints/10;
        return days;
    }
}