import java.util.*;

public class WishList {
    private ArrayList<Book> wishlist = new ArrayList<Book>();

    public ArrayList<Book> getWishList() {
        return wishlist;
    }

    public void addBook(Book b) {
        wishlist.add(b);
    }

    public void removeBook(Book b) {
        wishlist.remove(b);
    }
}