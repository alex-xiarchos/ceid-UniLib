import java.awt.print.Book;
import java.util.*;

public class WishList {
    private ArrayList<Book> wishlist = new ArrayList<Book>();

    public ArrayList<Book> getWishList() {
        return wishlist;
    }

    public void addBook(Book b) throws SameBookException {
        for (int i = 0; i < wishlist.size(); i++) {
            if (wishlist.get(i).equals(b)) {
                throw new SameBookException("This book is already in your Wish list!");
            }
        }
        wishlist.add(b);
    }

    public void removeBook(Book b) {
        wishlist.remove(b);
    }
}