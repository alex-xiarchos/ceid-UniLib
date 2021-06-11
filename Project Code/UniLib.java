import java.util.*;
public class UniLib {
    private static ArrayList<UserAccount> useraccountlist = new ArrayList<UserAccount>();
    private static ArrayList<Administrator> adminlist = new ArrayList<Administrator>();

    public static void main(String[] args) {
        Administrator admin = new Administrator("Ρουμελιώτης Κωνσταντίνος", "roumeliotis@upatras.gr", "roum12");
        adminlist.add(admin);
        String[] array = new String[] {"Νικηφόρος Παπαγεωργίου", "st1059633@ceid.upatras.gr", "nik23", String.valueOf(1059633), "CEID", String.valueOf(4), String.valueOf(1)};
        UserAccount ceidStudent = new UserAccount(array);
        useraccountlist.add(ceidStudent);

        Book book1 = new Book("Ψηφιακή Επεξεργασία Σήματος", "Πληροφορική", "Νικόλαος Λάσκαρης", "Συμμετρία", "978-960-110-034-0", "Βασικές έννοιες της ψηφιακής επεξεργασίας σημάτων.", 2);
        Book book2 = new Book("Ψηφιακή Επεξεργασία Σημάτων Ι", "Πληροφορική", "Θάνος Στουραΐτης", "Πανεπιστήμιο Πατρών", "978-560-155-2", "Άλλο ένα βιβλίο ΨΕΣ.", 8);
        Book book3 = new Book("Βασικές αρχές Τεχνολογίας Λογισμικού", "Πληροφορική", "Ian Sommerville", "Κλειδάριθμος", "978-960-461-220-8", "Βιβλίο Τεχνολογίας Λογισμικού", 5);
        Book book4 = new Book("Εισαγωγή στην Java", "Πληροφορική", "Γιώργος Λιακέας", "Κλειδάριθμος", "978-960-461-169-0", "Ένας ολοκληρωμένος και εύχρηστος οδηγός της γλώσσας Java", 1);

        BookLibrary patraLibrary = new BookLibrary("Βιβλιοθήκη & Κέντρο Πληροφόρησης - Πανεπιστήμιο Πατρών", "Υπατίας, Πανεπιστημιούπολη Πατρών", "bibliothiki@upatras.gr", "2610 96962");

        patraLibrary.addBook(book1);
        patraLibrary.addBook(book2);
        patraLibrary.addBook(book3);
        patraLibrary.addBook(book4);

        /* Δανεισμός βιβλίου για ανάγκες testing της receiveBook */
        BookToReceive rcvbook = new BookToReceive(book3, ceidStudent);
        patraLibrary.getBooksToReceive().add(rcvbook);
        System.out.println("\nΤο PIN σου: " + rcvbook.getBookToReceivePin().getPINnumber());
        System.out.println("Πρέπει να το παραλάβεις μέχρι: " + rcvbook.getPickupDateExpired());

        /* Παραλαβή βιβλίου για ανάγκες testing της returnBook */
        BookToReturn returnbook = new BookToReturn(book2, ceidStudent);
        patraLibrary.getBooksToReturn().add(returnbook);
        System.out.println("\nΤο PIN επιστροφής: " + returnbook.getBookToReturnPin().getPINnumber());
        System.out.println("Πρέπει να το επιστρέψει μέχρι: " + returnbook.getReturnDate());

        Scanner input = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("\n1. Εγγραφή");
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
                        ArrayList<Integer> logintype = userLogin();
                        if (logintype.get(0) == 1) {
                            // ΧΡΗΣΤΗΣ
                            Scanner choice = new Scanner(System.in);
                            int userMenuChoice;
                            do {
                                System.out.println("\n1. Αναζήτηση");
                                System.out.println("2. Αποσύνδεση");
                                System.out.print("Επίλεξε: ");
                                userMenuChoice = choice.nextInt();
                                switch (userMenuChoice) {

                                    case 1:
                                        ArrayList<Book> results = searchBook(patraLibrary);
                                        System.out.print("Επίλεξε βιβλίο για δανεισμό: ");
                                        Scanner input_book = new Scanner(System.in);
                                        int book = input_book.nextInt();
                                        try {
                                            borrowBook(results.get(book-1), useraccountlist.get(logintype.get(1)), patraLibrary);
                                        } catch (FailBorrowException e) {}
                                        break;

                                    case 2:
                                        System.out.println("Επιτυχής αποσύνδεση.");
                                        System.exit(0);
                                        break;

                                    default:
                                        System.out.println("Το " + userChoice + " δεν είναι έγκυρη επιλογή! Παρακαλώ, επίλεξε ξανά!");
                                }
                            } while (userMenuChoice != 2);
                        }
                        if (logintype.get(0) == 2) {
                            // ΔΙΑΧΕΙΡΙΣΤΗΣ
                            Scanner choice = new Scanner(System.in);
                            int adminMenuChoice;
                            do {
                                System.out.println("\n1. Αναζήτηση");
                                System.out.println("2. Προσθήκη νέου βιβλίου");
                                System.out.println("3. Παραλαβή βιβλίου");
                                System.out.println("4. Επιστροφή βιβλίου");
                                System.out.println("5. Αποσύνδεση");
                                System.out.print("Επίλεξε: ");
                                adminMenuChoice = choice.nextInt();
                                switch (adminMenuChoice) {

                                    case 1:
                                        searchBook(patraLibrary);
                                        break;

                                    case 2:
                                        addNewBook(patraLibrary);
                                        break;

                                    case 3:
                                        try {
                                            receiveBook(patraLibrary);
                                        } catch (InvalidPinException e) {}
                                        finally {
                                            break;
                                        }

                                    case 4:
                                        try {
                                            returnBook(patraLibrary);
                                        } catch (InvalidPinException e) {}
                                        finally {
                                            break;
                                        }

                                    case 5:
                                        System.out.println("Επιτυχής αποσύνδεση.");
                                        System.exit(0);
                                        break;

                                    default:
                                        System.out.println("Το " + userChoice + " δεν είναι έγκυρη επιλογή! Παρακαλώ, επίλεξε ξανά!");
                                }
                            } while (adminMenuChoice != 5);
                        }
                    } catch (CannotLoginException e) {}
                    break;

                default:
                    System.out.println("Το " + userChoice + " δεν είναι έγκυρη επιλογή! Παρακαλώ, επίλεξε ξανά!");
            }
        } while (true);
    }

    public static void borrowBook(Book book, UserAccount account, BookLibrary library) throws FailBorrowException {
        if (account.getBorrowBooks() < 5 && book.getBook_copies() > 0) {
            BookToReceive receivebook = new BookToReceive(book, account); //Δημιουργία βιβλίου προς παραλαβή
            library.getBooksToReceive().add(receivebook); //προσθήκη βιβλίου στη λίστα παραλαβών της βιβλιοθήκης
            System.out.println("Επιτυχής δανεισμός");
            System.out.println("\nΤο PIN σου: " + receivebook.getBookToReceivePin().getPINnumber());
            System.out.println("Πρέπει να το παραλάβεις μέχρι: " + receivebook.getPickupDateExpired());
        }
        else if (account.getBorrowBooks() == 5) {
            throw new FailBorrowException("Η διαδικασία δανεισμού απέτυχε.\nΠρέπει να επιστρέψετε κάποιο βιβλίο για να δανειστείτε κάποιο νέο.");
        }
        else if (book.getBook_copies() == 0) {
            System.out.println("Το βιβλίο δεν είναι διαθέσιμο προς το παρον.\nΠροστέθηκε στη wish list σας.");
            account.getWishList().addBook(book); //Προσθήκη βιβλίου στη wishlist
        }
    }

    public static void receiveBook(BookLibrary library) throws InvalidPinException {
        System.out.print("Εισήγαγε PIN παραλαβής βιβλίου: ");
        Scanner input = new Scanner(System.in);
        String pin = input.nextLine();
        boolean validPinFlag = false;

        for (int i = 0; i < library.getBooksToReceive().size(); i++) {
            if (library.getBooksToReceive().get(i).getBookToReceivePin().getPINnumber().equals(pin)) {
                validPinFlag = true;
                System.out.println("\nΈγκυρο PIN");
                BorrowedBook mybook = new BorrowedBook(library.getBooksToReceive().get(i), library.getBooksToReceive().get(i).getUser()); //new BorrowedBook
                library.getBooksToReceive().get(i).getUser().newBorrowedBook(mybook);
                BookToReturn returnbook = new BookToReturn(library.getBooksToReceive().get(i), library.getBooksToReceive().get(i).getUser()); //new BookToReturn
                library.getBooksToReturn().add(returnbook); //προσθήκη βιβλίου στη λίστα επιστροφών της βιβλιοθήκης
                library.getBooksToReceive().remove(i); //αφαίρεση βιβλίου από τη λίστα παραλαβών
                System.out.println("Παραλαβή βιβλίου ολοκληρώθηκε.");
                break;
            }
        }
        if (validPinFlag == false) {
            throw new InvalidPinException("\nΜη αποδεκτό PIN");
        }
    }

    public static void returnBook(BookLibrary library) throws InvalidPinException {
        System.out.print("Εισήγαγε PIN επιστροφής βιβλίου: ");
        Scanner input = new Scanner(System.in);
        String pin = input.nextLine();
        boolean validPinFlag = false;

        for (int i = 0; i < library.getBooksToReturn().size(); i++) {
            if (library.getBooksToReturn().get(i).getBookToReturnPin().getPINnumber().equals(pin)) {
                validPinFlag = true;
                System.out.println("\nΈγκυρο PIN");
                library.getBooksToReturn().get(i).aBookIsReturned(); //book copy added by 1
                //borrowed book removed from account list - borrow limited by 1
                for (int j = 0; j < library.getBooksToReturn().get(i).getUser().getMyBooks().size(); j++) {
                    if (library.getBooksToReturn().get(i).getUser().getMyBooks().get(j).getTitle() == library.getBooksToReturn().get(i).getTitle()) {
                        library.getBooksToReturn().get(i).getUser().newReturnedBook(library.getBooksToReturn().get(i).getUser().getMyBooks().get(j));
                        break;
                    }
                }
                library.getBooksToReturn().remove(i); //αφαίρεση βιβλίου από τη λίστα επιστροφών
                System.out.println("Επιστροφή βιβλίου ολοκληρώθηκε.");
                break;
            }
        }
        if (validPinFlag == false) {
            throw new InvalidPinException("Μη αποδεκτό PIN");
        }
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
        /* Σαρώνουμε την useraccountlist για να δούμε αν υπάρχει ήδη εγγεγραμμένος χρήστης
           στο σύστημα με το ίδιο email. Σε περίπτωση που υπάρχει, εγείρεται εξαίρεση. */
        for (int i = 0; i < useraccountlist.size(); i++) {
            if (useraccountlist.get(i).getUser().getEmail().equals(email)) {
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

        // Αποθήκευση των στοιχείων στην userInfo (μαζί με το choice).
        if (choice == 1) {
            String[] userInfo = new String[] {name, email, password, String.valueOf(id), department, String.valueOf(year), String.valueOf(choice)};
            UserAccount account = new UserAccount(userInfo); // Δημιουργία ενός νέου Account και αυτόματα user μέσω αυτού.
            useraccountlist.add(account); // Προσθήκη του λογαριασμού στην useraccountlist του συστήματος
        }else if (choice == 2) {
            String[] userInfo = new String[] {name, email, password, String.valueOf(id), department, String.valueOf(0), String.valueOf(choice)};
            UserAccount account = new UserAccount(userInfo); // Δημιουργία ενός νέου Account και αυτόματα user μέσω αυτού.
            useraccountlist.add(account); // Προσθήκη του λογαριασμού στην useraccountlist του συστήματος
        }


        //System.out.println(useraccountlist);  // Εκτύπωση του περιεχομένου του useraccountlist για λόγους debbuging.

        return choice;
    }

    public static ArrayList<Integer> userLogin() throws CannotLoginException {
        System.out.println("Σύνδεση");
        System.out.println("=============================================");

        Scanner input_email = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input_email.nextLine();

        Scanner input_password = new Scanner(System.in);
        System.out.print("\nPassword: ");
        String password = input_password.nextLine();

        ArrayList<Integer> loginResult = new ArrayList<Integer>();

        for (int i = 0; i < useraccountlist.size(); i++) {
            if (email.equals(useraccountlist.get(i).getUser().getEmail()) && password.equals(useraccountlist.get(i).getUser().getPassword())) {
                System.out.println("\nΕπιτυχής σύνδεση χρήστη!");
                loginResult.add(1);
                loginResult.add(i);
                return loginResult;
            }
        }

        for (int i = 0; i < adminlist.size(); i++) {
            if (email.equals(adminlist.get(i).getEmail()) && password.equals(adminlist.get(i).getPassword())) {
                System.out.println("\nΕπιτυχής σύνδεση διαχειριστή!");
                loginResult.add(2);
                loginResult.add(i);
                return loginResult;
            }
        }
        throw new CannotLoginException("\nΑποτυχία σύνδεσης");
    }

    public static ArrayList<Book> searchBook(BookLibrary library) {
        Scanner input = new Scanner(System.in);
        System.out.print("Εισήγαγε λήμμα αναζήτησης: ");
        String lemma = input.nextLine();
        ArrayList<Book> results = new ArrayList<Book>();

        try {
            for (int i = 0; i < library.getBooksByTitle(lemma).size(); i++) {
                results.add(library.getBooksByTitle(lemma).get(i));
            }
        } catch (SearchWarningException e1) {
            try {
                for (int i = 0; i < library.getBooksByAuthor(lemma).size(); i++) {
                    results.add(library.getBooksByAuthor(lemma).get(i));
                }
            } catch (SearchWarningException e2) {
                try {
                    for (int i = 0; i < library.getBooksByPublisher(lemma).size(); i++) {
                        results.add(library.getBooksByPublisher(lemma).get(i));
                    }
                } catch (SearchWarningException e3) {
                    try {
                        for (int i = 0; i < library.getBooksByISBN(lemma).size(); i++) {
                            results.add(library.getBooksByISBN(lemma).get(i));
                        }
                    } catch (SearchWarningException e4) {
                        System.out.println("Δεν βρέθηκαν αποτελέσματα αναζήτησης.");
                    }
                }
            }
        }

        if (results.size() > 0) {
            System.out.println("\nΒρέθηκαν " + results.size() + " βιβλία.");
            System.out.println("=============================================");

            for (int i = 0; i < results.size(); i++) {
                System.out.println(i+1 + ". " + results.get(i).getTitle());
            }
            System.out.println("=============================================");
        }
        return results;
    }

    public static void addNewBook(BookLibrary library) {
        ArrayList<Book> librarylist = library.getLibrary();
        boolean duplicateFlag = false;

        System.out.println("ΦΟΡΜΑ ΠΡΟΣΘΗΚΗΣ ΝΕΟΥ ΒΙΒΛΙΟΥ");
        System.out.println("=================================");

        Scanner input_title = new Scanner(System.in);
        System.out.print("Τίτλος: ");
        String title = input_title.nextLine();

        Scanner input_category = new Scanner(System.in);
        System.out.print("\nΚατηγορία: ");
        String category = input_title.nextLine();

        Scanner input_author = new Scanner(System.in);
        System.out.print("\nΣυγγραφέας: ");
        String author = input_author.nextLine();

        Scanner input_publisher = new Scanner(System.in);
        System.out.print("\nΕκδοτικός οίκος: ");
        String publisher = input_publisher.nextLine();

        Scanner input_isbn = new Scanner(System.in);
        System.out.print("\nISBN: ");
        String isbn = input_isbn.nextLine();

        for (int i = 0; i < librarylist.size(); i++) {
            if (librarylist.get(i).getTitle().equals(title) || librarylist.get(i).getISBN().equals(isbn)) {
                duplicateFlag = true;
                System.out.println("Βρέθηκε αντιστοιχία με το βιβλίο: '" + librarylist.get(i).getTitle() + "'.");
                Scanner input = new Scanner(System.in);
                System.out.println("Πατήστε (1) για ακύρωση προσθήκης, ή (2) για προσθήκη αντιτύπων");
                int choice = input.nextInt();
                if (choice == 1) {
                    System.out.println("Επιτυχής ακύρωση προσθήκης νέου βιβλίου.");
                    break;
                }
                if (choice == 2) {
                    Scanner input_copies = new Scanner(System.in);
                    System.out.print("Εισήγαγε αριθμό αντιτύπων: ");
                    int copies = input_copies.nextInt();
                    librarylist.get(i).setCopies(copies);
                    System.out.println("\nΕπιτυχής προσθήκη αντιτύπων.");
                }
            }
        }

        if (duplicateFlag == false) {
            Scanner input_details = new Scanner(System.in);
            System.out.print("\nΠεριγραφή: ");
            String details = input_details.nextLine();

            Scanner input_copies = new Scanner(System.in);
            System.out.print("\nΑντίτυπα: ");
            int copies = input_copies.nextInt();

            Book newbook = new Book(title, category, author, publisher, isbn, details, copies);
            System.out.println("Βιβλίο καταχωρήθηκε.");
            library.addBook(newbook);
        }
    }
}