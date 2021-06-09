import java.util.*;

public class Catalog {
    private Map<String, ArrayList<Book>> bookTitles = new HashMap<String, ArrayList<Book>>();
    private Map<String, ArrayList<Book>> bookAuthors = new HashMap<String, ArrayList<Book>>();
    private Map<String, ArrayList<Book>> bookPublishers = new HashMap<String, ArrayList<Book>>();
    private Map<String, ArrayList<Book>> bookISBNs = new HashMap<String, ArrayList<Book>>();
}