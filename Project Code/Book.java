public class Book {
    private String title;
    private String category;
    private String author;
    private String publishing_house;
    private String ISBN;
    private String details;
    private int book_copies;

    public Book(String title, String category, String author, String publishing_house, String ISBN, String details, int book_copies) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publishing_house = publishing_house;
        this.ISBN = ISBN;
        this.details = details;
        this.book_copies = book_copies;
    }

    /* GETTERS & SETTERS */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishing_house;
    }

    public void setPublishingHouse(String publishing_house) {
        this.publishing_house = publishing_house;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getDetails() {
        return details;
    }

    public int getBook_copies() {
        return book_copies;
    }

    public void aBookIsReturned() {
        book_copies += 1;
    }

    public void aBookIsBorrowed() {
        book_copies -= 1;
    }

    public String[] getInfo(){
		String[] array = new String[] {this.title, this.category, this.author, this.publishing_house, this.ISBN, this.details, String.valueOf(this.book_copies)};
		return array;
	}
}