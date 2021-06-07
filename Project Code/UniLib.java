import java.util.*;
public class UniLib {
    private static ArrayList<User> userlist = new ArrayList<User>();
    private static ArrayList<Administrator> adminlist = new ArrayList<Administrator>();

    public static void main(String args[]) {
        Administrator admin = new Administrator("Ρουμελιώτης Κωνσταντίνος", "roumeliotis@upatras.gr", "roum12");
        adminlist.add(admin);
        Student ceidStudent = new Student("Νικηφόρος Παπαγεωργίου", "st1059633@ceid.upatras.gr", "nik23", 1059633, "CEID", 4);
        userlist.add(ceidStudent);

        Book book1 = new Book("Ψηφιακή Επεξεργασία Σήματος", "Πληροφορική", "Νικόλαος Λάσκαρης", "Συμμετρία", "DSP2748210", "Βασικές έννοιες της ψηφιακής επεξεργασίας σημάτων.", 2);
        Book book2 = new Book("Ψηφιακή Επεξεργασία Σημάτων Ι", "Πληροφορική", "Θάνος Στουραΐτης", "Πανεπιστήμιο Πατρών", "DSP2755210", "Άλλο ένα βιβλίο ΨΕΣ.", 8);

        BookLibrary patraLibrary = new BookLibrary("Υπατίας, Πανεπιστημιούπολη Πατρών", "bibliothiki@upatras.gr", "2610 96962");

        patraLibrary.addBook(book1);
        patraLibrary.addBook(book2);

        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("1. Εγγραφή");
            System.out.println("2. Σύνδεση");
            System.out.print("Επίλεξε: ");
            userChoice = input.nextInt();

            switch (userChoice) {

                case 1:
                    try {
                        int choice = registerUser();
                    } catch (AlreadyUsedAccountException e) {}
                    break;

                case 2:
                    try {
                        userLogin();
                    } catch (CannotLoginException e) {}
                    break;

                default:
                    System.out.println("Το " + userChoice + " δεν είναι έγκυρη επιλογή! Παρακαλώ, επίλεξε ξανά!");
            }
        } while (true);


/*        for (int i = 0; i < userlist.size(); i++) {1
            System.out.println(userlist.get(i).getName());
        }
*/

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

    public static int registerUser() throws AlreadyUsedAccountException {
        Scanner input = new Scanner(System.in);
        int year;

        System.out.println("Καλώς όρισες!");
        System.out.println("Γράψε (1) για φοιτητής, (2) για πανεπιστημιακό προσωπικό");
        int choice = input.nextInt();

        Scanner input_name = new Scanner(System.in);
        System.out.println("\nΔώσε το όνομά σου");
        String name = input_name.nextLine();

        Scanner input_email = new Scanner(System.in);
        System.out.println("\nΔώσε το email σου");
        String email = input_email.nextLine();
        /* Σαρώνουμε την userlist για να δούμε αν υπάρχει ήδη εγγεγραμμένος χρήστης
           στο σύστημα με το ίδιο email. Σε περίπτωση που υπάρχει, εγείρεται εξαίρεση. */
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getEmail().equals(email)) {
                throw new AlreadyUsedAccountException("Το email αντιστοιχεί σε ήδη εγγεγραμμένο χρήστη");
            }
        }

        Scanner input_password = new Scanner(System.in);
        System.out.println("\nΔώσε ένα συνθηματικό");
        String password = input_password.nextLine();

        Scanner input_id = new Scanner(System.in);
        System.out.println("\nΔώσε το Α.Μ. σου");
        int id = input_id.nextInt();

        if (choice == 1) {
            Scanner input_year = new Scanner(System.in);
            System.out.println("\nΔώσε το ακαδημαϊκό σου έτος");
            year = input_year.nextInt();
        }
        else {
            year = 0;
        }

        Scanner input_department = new Scanner(System.in);
        System.out.println("\nΔώσε το Τμήμα σου");
        String department = input_department.nextLine();

        if (choice == 1) {
            Student student = new Student(name, email, password, id, department, year); // Δημιουργία ενός νέου Student
            userlist.add(student); // Προσθήκη του χρήστη στην userlist του συστήματος
        }
        else if (choice == 2) {
            UniStaff unistaff = new UniStaff(name, email, password, id, department); // Δημιουργία ενός νέου Unistaff
            userlist.add(unistaff); // Προσθήκη του χρήστη στην userlist του συστήματος
        }

        return choice;
    }

    public static void userLogin() throws CannotLoginException {
        System.out.println("Σύνδεση");
        System.out.println("=============================================");

        Scanner input_email = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input_email.nextLine();

        Scanner input_password = new Scanner(System.in);
        System.out.print("\nPassword: ");
        String password = input_password.nextLine();

        boolean loginFlag = false;

        for (int i = 0; i < userlist.size(); i++) {
            if (email.equals(userlist.get(i).getEmail()) && password.equals(userlist.get(i).getPassword())) {
                System.out.println("\nΕπιτυχής σύνδεση χρήστη!");
                loginFlag = true;
                break;
            }
        }

        for (int i = 0; i < adminlist.size(); i++) {
            if (email.equals(adminlist.get(i).getEmail()) && password.equals(adminlist.get(i).getPassword())) {
                System.out.println("\nΕπιτυχής σύνδεση διαχειριστή!");
                loginFlag = true;
                break;
            }
        }

        if (loginFlag == false) {
            throw new CannotLoginException("\nΑποτυχία σύνδεσης");
        }
    }
}