import java.util.*;

public class MyBooks {
    private ArrayList<BorrowedBook> mybookslist = new ArrayList<BorrowedBook>(5);

    public void addBorrowedBook(BorrowedBook b) {
        mybookslist.add(b);
    }

    public void removeBorrowedBook(BorrowedBook b) {
        mybookslist.remove(b);
    }
}