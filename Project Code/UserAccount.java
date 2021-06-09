import java.util.ArrayList;

public class UserAccount {
    private boolean active = true;
    private int borrowedBooks = 0;
    private int reservedBooks = 0;
    private int fine_number = 0;
    private User user;
    private ArrayList<BorrowedBook> mybookslist = new ArrayList<BorrowedBook>(5);


    public UserAccount(String[] userInfo) {

        /*  Αυτόματη δημιουργία είτε Student, είτε Staff με βάση τις πληροφορίες του userInfo και αποθήκευση 
            στο αντικείμενο user του userAccount */
        if(Integer.parseInt(userInfo[6]) == 1){
            Student student = new Student(userInfo[0], userInfo[1], userInfo[2], Integer.parseInt(userInfo[3]), userInfo[4], Integer.parseInt(userInfo[5]));
            this.user = student;
        }
        else if(Integer.parseInt(userInfo[6]) == 2){
            UniStaff unistaff = new UniStaff(userInfo[0], userInfo[1], userInfo[2], Integer.parseInt(userInfo[3]), userInfo[4]); // Δημιουργία ενός νέου Unistaff
            this.user = unistaff;
        }
    }

    public ArrayList<BorrowedBook> getMyBooksList() {
        return mybookslist;
    }


    public void setActive(boolean isActive) {
        active = isActive;
    }

    public int getBorrowBooks() {
        return borrowedBooks;
    }

    public int getReserveBooks() {
        return reservedBooks;
    }

    public void newBorrowedBook(BorrowedBook book) {
        borrowedBooks += 1;
        mybookslist.add(book);
    }

    public void newReturnedBook(BorrowedBook book) {
        borrowedBooks -= 1;
        mybookslist.remove(book);
    }

    public int getFine() {
        return fine_number;
    }

    public void setFine(int fine) {
        fine_number = fine;
    }

    public User getUser() {
        return user;
    }
}