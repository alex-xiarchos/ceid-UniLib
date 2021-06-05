import java.util.*;

public class BookLibrary {

	private String libraryName;
    private String email;
	private String address;
	private String telephone;
	private ArrayList<Book> library = new ArrayList<Book>();

	public String getAddress(){
		return address;
	}
  
	public BookLibrary (String parAddress, String parEmail, String parTel) {
		address = parAddress;
		email = parEmail;
		telephone = parTel;
	}
                     
	public String getTelephone(){
		return telephone;
	}

	public void addBook(Book b) {
		library.add(b);
	}

	public void removeBook(Book b) {
		library.remove(b);
	}

	public Book getBookByTitle(String book_title) throws SearchWarningException {
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getTitle() == book_title) {
                return library.get(i);
            }
        }
		throw new SearchWarningException("No book with title: " + book_title + " was found.");
	}

	public Book getBookByAuthor(String book_author) throws SearchWarningException {
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getAuthor() == book_author) {
                return library.get(i);
            }
        }
		throw new SearchWarningException("No book with author: " + book_author + " was found.");
	}

	public Book getBookByPublisher(String book_publisher) throws SearchWarningException {
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getPublishingHouse() == book_publisher) {
                return library.get(i);
            }
        }
		throw new SearchWarningException("No book from publishing house: " + book_publisher + " was found.");
	}

	public Book getBookByISBN(String book_isbn) throws SearchWarningException {
		for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getISBN() == book_isbn) {
                return library.get(i);
            }
        }
		throw new SearchWarningException("No book with ISBN: " + book_isbn + " was found.");
	}
}
