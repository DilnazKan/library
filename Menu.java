import entities.Book;
import entities.StaffBook;
import entities.interfaces.IBook;
import entities.interfaces.IUser;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final ILibrary library;

    public Menu(ILibrary library) {
        this.scanner = new Scanner(System.in);
        this.library = library;
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the library!");

            System.out.println("==================================");
            System.out.println("Operation over books:");
            System.out.println("1. Add a book");
            System.out.println("2. Get all books");
            System.out.println("3. Get a book by ISBN");
            System.out.println("4. Update a book");
            System.out.println("5. Remove a book");

            System.out.println("==================================");
            System.out.println("Operation over users:");
            System.out.println("6. Add a user");
            System.out.println("7. Get all users");
            System.out.println("8. Get a user by ID");
            System.out.println("9. Update a user");
            System.out.println("10. Remove a user");

            System.out.println("==================================");
            System.out.println("Other operations:");
            System.out.println("11. Borrow a book");
            System.out.println("12. Return a book");

            System.out.println("==================================");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                case "1":
                   addBook();
                    break;

                case "2":
                    System.out.println("Not implemented yet!");
                    ArrayList<IBook> books = library.getBooks();

                    break;

                case "3":
                    // ???????? 2 ???????? ??????????????????????????: ???????????????? ?? ???????????????????? ????????????????????.
                    // Student(int id, String name)
                    // Staff(int id, String name)
                    System.out.println("Not implemented yet!");
                    break;

                case "4":
                    System.out.println("Not implemented yet!");
                    break;

                case "5":
                    removeBook();
                    break;

                case "6":
                    System.out.println("Not implemented yet!");
                    break;

                case "7":
                    System.out.println("Not implemented yet!");
                    break;

                case "8":
                    System.out.println("Not implemented yet!");
                    break;

                case "9":
                    System.out.println("Not implemented yet!");
                    break;

                case "10":
                    System.out.println("Not implemented yet!");
                    break;

                case "11":
                    borrowBook();
                    break;

                case "12":
                    System.out.println("Not implemented yet!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;

            }
        }
    }
    public void addBook(){
        System.out.println("Enter the ISBN of the book:");
        int isbn = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();

        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();

        System.out.println("Enter the year of the book:");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the genre of the book:");
        String genre = scanner.nextLine();

        System.out.println("Enter the count of the book:");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println("Is this book staff only? (y/n)");
        boolean staffOnly = scanner.nextLine().equalsIgnoreCase("y");

        // ???????? 2 ???????? ????????: ?????????????? ?? ?????? ??????????????????
        // ?????????? ?????? ?????????????????? ?????????? ???????? ???????????? ???????????? ??????????????????
        // ???? ???????? ?????? Staff

        IBook book;
        if (staffOnly) {
            book = new StaffBook(isbn, title, author, year, genre, count);
        } else {
            book = new Book(isbn, title, author, year, genre, count);
        }

        try {
            library.addBook(book);
        } catch (Exception e) {
            // ???????? ??????-???? ???????????? ???? ??????, ???? ???????????????? ????????????
            // ????????????????, ???????? ?????????? ?? ?????????? ISBN ?????? ???????? ?? ????????????????????
            // ?????? ???????????? ???????????????????? ?????????? ?????????????? ????????????
            // ?????????????? ???? ?????????? ????????????????????????
            System.out.println("Failed to add book: " + e.getMessage());
        }

        System.out.println("entities.Book added!");
    }
    public void removeBook() {
        System.out.println("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());


        IUser user = library.getUser(id);
        if (user.isStaff()) {
            System.out.println("Enter ISBN of the book: ");
            int isbn = Integer.parseInt(scanner.nextLine());
            IBook book= library.getBook(isbn);
            library.removeBook(book);
        }
        else {
            System.out.println("You don't have access!");
        }
    }
   public void borrowBook() {
        System.out.println("Enter user ID:");
        int id = Integer.parseInt(scanner.nextLine());

       System.out.println("Enter the ISBN of the book:");
       int isbn = Integer.parseInt(scanner.nextLine());
       IUser borrowIUser = library.getUser(id);
       IBook book = library.getBook(isbn);

       library.borrowBook(book, borrowIUser);
    }

    public void returnBook() {
        System.out.println("Enter user ID:");
        int id = Integer.parseInt(scanner.nextLine()); // ?????????????????????? ?? ??????????????????

        System.out.println("Enter the ISBN of the book:");
        int isbn = Integer.parseInt(scanner.nextLine());

        IUser returnIUser = library.getUser(id); // ???????????????? ?????????? ?? ???????? ????????????, ?????? ????????
        IBook book = library.getBook(isbn); //?????? ??????????????????

        library.returnBook(book,returnIUser);// ???????????????????? ??????????
        System.out.println("Your book successfully return!");
    }

    public void updateBook() {
        System.out.println("Enter the ISBN of the book:");
        int isbn = Integer.parseInt(scanner.nextLine());
        IBook book = library.getBook(isbn); //???????????????? ?????????? ???? ?????????? ?????????? ???????? ????????????????????
        System.out.println("What you want to change?( title/ author/ year/ genre/ count)");

        String choice = scanner.nextLine();
        switch (choice) {
            case "title" :
                System.out.println("Enter a new title of the book: ");
                String title = scanner.nextLine(); // ?????????????????? ???????????????? ??????????????
                book = new Book(isbn, title, book.getAuthor(), book.getYear(), book.getGenre(), book.getCount());
                // ?????????????? ?????????? ?????????? ?????????? ?????? ?????? ???? ????????????????
                break;


            case "author" :
                System.out.println("Enter a new author of the book: ");
                String author = scanner.nextLine();
                book = new Book(isbn, book.getTitle(),author, book.getYear(), book.getGenre(), book.getCount());
                break;


            case "genre" :
                System.out.println("Enter a new genre of the book: ");
                String genre = scanner.nextLine();
                book = new Book(isbn, book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre(), book.getCount());
                break;


            case "year" :
                System.out.println("Enter a new year of the book");
                int year = Integer.parseInt(scanner.nextLine());
                book = new Book(isbn, book.getTitle(), book.getAuthor(), year, book.getGenre(), book.getCount());
                break;


            case "count" :
                System.out.println("Enter s new count of the book");
                int count = Integer.parseInt(scanner.nextLine());
                book = new Book(isbn, book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre(), count);
                break;
            default:
                System.out.println("This is not correct");
                return;
        }
        library.updateBook(book);
        System.out.println("Operation is done successfully");

    }
}
