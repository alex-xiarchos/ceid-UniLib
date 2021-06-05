import java.util.*;
public class UniLib {
    public static void main(String args[]) {
        Administrator admin = new Administrator("Ρουμελιώτης Κωνσταντίνος", "roumeliotis@upatras.gr", "roum12");
        Student ceidStudent = new Student("Νικηφόρος Παπαγεωργίου", "nik23", "st1059633@ceid.upatras.gr", 1059633, "CEID", 4);

        Book book1 = new Book("Ψηφιακή Επεξεργασία Σήματος", "Πληροφορική", "Νικόλαος Λάσκαρης", "Συμμετρία", "DSP2748210", "Βασικές έννοιες της ψηφιακής επεξεργασίας σημάτων.", 2);

        Book book2 = new Book("Ψηφιακή Επεξεργασία Σημάτων Ι", "Πληροφορική", "Θάνος Στουραΐτης", "Πανεπιστήμιο Πατρών", "DSP2755210", "Άλλο ένα βιβλίο ΨΕΣ.", 8);

        BookLibrary patraLibrary = new BookLibrary("Υπατίας, Πανεπιστημιούπολη Πατρών", "bibliothiki@upatras.gr", "2610 96962");

        patraLibrary.addBook(book1);
        patraLibrary.addBook(book2);

        UserAccount account = new UserAccount(ceidStudent);

        try {
            borrowBook(book2, account);
        }
        catch(FailBorrowException e) {}
    }

    public static void borrowBook(Book book, UserAccount account) throws FailBorrowException{
        if (account.getBorrowBooks() < 5 && book.getBook_copies() > 0) {
            System.out.println("You can borrow.");

            BorrowedBook mybook1 = new BorrowedBook(book, account.getUser());
            book.bookGetsBorrowed();
            account.addBorrowedBook(mybook1);

            System.out.println(account.getMyBooksList().get(0).getTitle());
        }
        else
            throw new FailBorrowException("You can't borrow");

    }
}