public class Book {
	private String idBook;
	private String type;
	private String author;
	private String publisher;
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String toString() {
		return "Book [idBook=" + idBook + ", type=" + type + ", author="
				+ author + ", publisher=" + publisher + "]";
	}

}