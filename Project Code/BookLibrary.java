import java.util.*;

public class BookLibrary {

	private String libraryName;
    private String email;
	private String address;
	private String telephone;
	private ArrayList<Book> library = new ArrayList<Book>();
	private ArrayList<BookToReceive> booksToReceive = new ArrayList<BookToReceive>();
	private ArrayList<BookToReturn> booksToReturn = new ArrayList<BookToReturn>();

	public String getAddress(){
		return address;
	}
  
	public BookLibrary (String name, String parAddress, String parEmail, String parTel) {
		libraryName = name;
		address = parAddress;
		email = parEmail;
		telephone = parTel;
	}
                     
	public String getTelephone(){
		return telephone;
	}

	public String getEmail() {
		return email;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void addBook(Book b) {
		library.add(b);
	}

	public void removeBook(Book b) {
		library.remove(b);
	}

	public ArrayList<Book> getLibrary() {
		return library;
	}

	public ArrayList<BookToReceive> getBooksToReceive() {
		return booksToReceive;
	}

	public ArrayList<BookToReturn> getBooksToReturn() {
		return booksToReturn;
	}

	public ArrayList<Book> getBooksByTitle(String book_title) throws SearchWarningException {
		ArrayList<Book> booksByTitle = new ArrayList<Book>();
		boolean flag = false;
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getTitle().contains(book_title)) {
                booksByTitle.add(library.get(i));
                flag = true;
            }
        }
		if (flag == true) {
			return booksByTitle;
		}
		else {
			throw new SearchWarningException();
		}
	}

	public ArrayList<Book> getBooksByAuthor(String book_author) throws SearchWarningException {
		ArrayList<Book> booksByAuthor = new ArrayList<Book>();
		boolean flag = false;
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getAuthor().contains(book_author)) {
                booksByAuthor.add(library.get(i));
                flag = true;
            }
        }
		if (flag == true) {
			return booksByAuthor;
		}
		else {
			throw new SearchWarningException();
		}
	}

	public ArrayList<Book> getBooksByPublisher(String book_publisher) throws SearchWarningException {
		ArrayList<Book> booksByPublisher = new ArrayList<Book>();
		boolean flag = false;
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getPublishingHouse().contains(book_publisher)) {
                booksByPublisher.add(library.get(i));
                flag = true;
            }
        }
		if (flag == true) {
			return booksByPublisher;
		}
		else {
			throw new SearchWarningException();
		}
	}

	public ArrayList<Book> getBooksByISBN(String book_isbn) throws SearchWarningException {
		ArrayList<Book> booksByISBN = new ArrayList<Book>();
		boolean flag = false;
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getISBN().contains(book_isbn)) {
                booksByISBN.add(library.get(i));
                flag = true;
            }
        }
		if (flag == true) {
			return booksByISBN;
		}
		else {
			throw new SearchWarningException();
		}
	}
}
