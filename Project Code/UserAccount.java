import java.util.ArrayList;

public class UserAccount {
    private boolean active = true;
    private int borrowedBooks = 0;
    private int reservedBooks = 0;
    private int fine_number = 0;
    private User user;
    private ArrayList<BorrowedBook> mybookslist = new ArrayList<BorrowedBook>(5);


    public UserAccount(User user) {
        this.user = user;
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