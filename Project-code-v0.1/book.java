public class Book {
	private String title;
	private String category;
	private String author;
	private String publishing_house;
	private String ISBN;
	private String details;

	public Book(String title, String category, String author, String publishing_house, String ISBN, String details){
		this.title = title;
		this.category = category;
		this.author = author;
		this.publishing_house = publishing_house;
		this.ISBN = ISBN;
		this.details = details;
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

	public String[] getInfo(){
		String[] array = new String[] {this.title, this.category, this.author, this.publishing_house, this.ISBN, this.details};
		return array;
	}

}