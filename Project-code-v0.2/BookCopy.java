public class BookCopy {
    private String book_title;
    private int book_copy_number;

    public BookCopy(String book_title, int book_copy_number) {
        this.book_title = book_title;
        this.book_copy_number = book_copy_number;
    }

    public int getCopyNum() {
        return book_copy_number;
    }

    public void setCopyNum(int copies) {
        book_copy_number = copies;
    }

    public void addCopyNum() {
        book_copy_number += 1;
    }

    public void removeCopyNum() {
        book_copy_number -= 1;
    }
}