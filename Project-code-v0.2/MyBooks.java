import java.util.*;

public class MyBooks {
    private ArrayList<BorrowedBook> mybookslist = new ArrayList<BorrowedBook>(5);

    public ArrayList<BorrowedBook> getMyBooksList() {
        return mybookslist;
    }

    public void addBorrowedBook(BorrowedBook b) {
        mybookslist.add(b);
    }

    public void removeBorrowedBook(BorrowedBook b) {
        mybookslist.remove(b);
    }
}