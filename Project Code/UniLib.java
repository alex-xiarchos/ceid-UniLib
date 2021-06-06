import java.util.*;
public class UniLib {
    public static void main(String args[]) {
//        Administrator admin = new Administrator("Ρουμελιώτης Κωνσταντίνος", "roumeliotis@upatras.gr", "roum12");
//        Student ceidStudent = new Student("Νικηφόρος Παπαγεωργίου", "nik23", "st1059633@ceid.upatras.gr", 1059633, "CEID", 4);

        registerUser();

        Book book1 = new Book("Ψηφιακή Επεξεργασία Σήματος", "Πληροφορική", "Νικόλαος Λάσκαρης", "Συμμετρία", "DSP2748210", "Βασικές έννοιες της ψηφιακής επεξεργασίας σημάτων.", 2);
        Book book2 = new Book("Ψηφιακή Επεξεργασία Σημάτων Ι", "Πληροφορική", "Θάνος Στουραΐτης", "Πανεπιστήμιο Πατρών", "DSP2755210", "Άλλο ένα βιβλίο ΨΕΣ.", 8);

        BookLibrary patraLibrary = new BookLibrary("Υπατίας, Πανεπιστημιούπολη Πατρών", "bibliothiki@upatras.gr", "2610 96962");

        patraLibrary.addBook(book1);
        patraLibrary.addBook(book2);

//        try {
//            borrowBook(book2, account);
//        }
//        catch(FailBorrowException e) {}
    }

    public static void borrowBook(Book book, UserAccount account) throws FailBorrowException {
        if (account.getBorrowBooks() < 5 && book.getBook_copies() > 0) {

            BorrowedBook mybook1 = new BorrowedBook(book, account.getUser());

            book.aBookIsBorrowed();             //book copy reduced by 1
            account.newBorrowedBook(mybook1);   //borrowed book added to account list - borrow limit reduced by 1

        }
        else
            throw new FailBorrowException("You can't borrow");

    }

    public static void returnBook(BorrowedBook book, UserAccount account) {
        book.aBookIsReturned();                 //book copy added by 1
        account.newReturnedBook(book);          //borrowed book removed from account list - borrow limited added by 1
    }

    public static int registerUser() {
        Scanner input = new Scanner(System.in);
        String name, email, password, id, year, department;

        System.out.println("Γράψε (1) για μαθητής, (2) για πανεπιστημιακό προσωπικό");
        String choice = input.nextLine();

        System.out.println("Enter name");
        name = input.nextLine();
        System.out.println("Enter Email");
        email = input.nextLine();
        System.out.println("Enter Password");
        password = input.nextLine();

        System.out.println("Enter Student ID");
        id = input.nextLine();
        System.out.println("Enter academic year");
        year = input.nextLine();
        System.out.println("Enter Staff ID");
        id = input.nextLine();
        System.out.println("Enter Department");
        department = input.nextLine();

        if (Integer.parseInt(choice) == 1) {
            Student student = new Student(name, email, password, Integer.parseInt(id), department, Integer.parseInt(year));
        }
        else if (Integer.parseInt(choice) == 2) {
            UniStaff unistaff = new UniStaff(name, email, password, Integer.parseInt(id), department);
        }

        return Integer.parseInt(choice);
        }
}