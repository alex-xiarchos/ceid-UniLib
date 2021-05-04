public class Account {
    private boolean active = true;
    private int number_of_borrowed_books;
    private int number_of_reserved_books;
    private int fine_number;

    public Account(boolean active, int number_of_borrowed_books, int number_of_reserved_books, int fine_number) {
        this.active = active;
        this.number_of_borrowed_books = number_of_borrowed_books;
        this.number_of_reserved_books = number_of_reserved_books;
    }

    public void setActive(boolean isActive) {
        active = isActive;
    }

    public int getBorrowBooks() {
        return number_of_borrowed_books;
    }

    public void setBorrowBooks(int BorrowedBooks) {
        number_of_borrowed_books = BorrowedBooks;
    }

    public int getReserveBooks() {
        return number_of_reserved_books;
    }

    public void setReserveBooks(int ReservedBooks) {
        number_of_reserved_books = ReservedBooks;
    }

    public int getFine() {
        return fine_number;
    }

    public void setFine(int fine) {
        fine_number = fine;
    }
}
