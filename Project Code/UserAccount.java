import java.util.ArrayList;

public class UserAccount {
    private boolean active = true;
    private int number_of_borrowed_books = 0;
    private int number_of_reserved_books = 0;
    private int fine_number = 0;
    private User user;
    private ArrayList<BorrowedBook> mybookslist = new ArrayList<BorrowedBook>(5);


    public UserAccount(User user) {
        this.user = user;
    }

    public ArrayList<BorrowedBook> getMyBooksList() {
        return mybookslist;
    }

    public void addBorrowedBook(BorrowedBook b) {
        mybookslist.add(b);
    }

    public void removeBorrowedBook(BorrowedBook b) {
        mybookslist.remove(b);
    }

    public void setActive(boolean isActive) {
        active = isActive;
    }

    public int getBorrowBooks() {
        return number_of_borrowed_books;
    }

    public void setBorrowBooks(int BorrowedBooks) {
        number_of_borrowed_books = BorrowedBooks;
    }

    public int getReserveBooks() {
        return number_of_reserved_books;
    }

    public void setReserveBooks(int ReservedBooks) {
        number_of_reserved_books = ReservedBooks;
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