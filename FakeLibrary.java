import entities.Book;
import entities.interfaces.IBook;
import entities.interfaces.IUser;

import java.util.ArrayList;

public class FakeLibrary implements ILibrary {
    // Этот класс не является библиотекой, но он имитирует её.
    // Пока что она ничего не делает.
    // Не надо его трогать, это моя часть проекта.
    public FakeLibrary() {
        // Этот конструктор не делает ничего.
    }

    private void doNothing() {
        System.out.println("DEBUG: Library did nothing. It's OK.");
    }

    @Override
    public ArrayList<IBook> getBooks() {
        doNothing();
        ArrayList<IBook> books = new ArrayList<>();
        books.add(
                new Book(
                        1,
                        "The Lord of the Rings",
                        "J. R. R. Tolkien",
                        1954,
                        "Fantasy",
                        10
                )
        );
        books.add(
                new Book(
                        2,
                        "The Hobbit",
                        "J. R. R. Tolkien",
                        1937,
                        "Fantasy",
                        15
                )
        );
        return books;
    }

    @Override
    public IBook getBook(int isbn) {
        doNothing();
        return new Book(
                1,
                "Sample entities.Book",
                "Author",
                2000,
                "Genre",
                10
        );
    }

    @Override
    public void addBook(IBook book) {
        doNothing();
    }

    @Override
    public void updateBook(IBook book) {
        doNothing();
    }

    @Override
    public void removeBook(IBook book) {
        doNothing();
    }

    @Override
    public ArrayList<IUser> getUsers() {
        doNothing();
        ArrayList<IUser> users = new ArrayList<>();
        ArrayList<IBook> books = new ArrayList<>();
        books.add(
                new Book(
                        1,
                        "The Lord of the Rings",
                        "J. R. R. Tolkien",
                        1954,
                        "Fantasy",
                        2
                )
        );
        users.add(new Student(1, "John"));
        users.add(new Student(2, "Jane"));
        users.add(new Staff(3, "Umbrella (staff)", books));
        return users;
    }

    @Override
    public IUser getUser(int id) {
        doNothing();
        ArrayList<IBook> books = new ArrayList<>();
        books.add(
                new Book(
                        1,
                        "The Lord of the Rings",
                        "J. R. R. Tolkien",
                        1954,
                        "Fantasy",
                        1
                )
        );
        books.add(
                new Book(
                        2,
                        "The Hobbit",
                        "J. R. R. Tolkien",
                        1937,
                        "Fantasy",
                        2
                )
        );
        return new Student(id, "Sample Student", books);
    }

    @Override
    public void addUser(IUser user) {
        doNothing();
    }

    @Override
    public void updateUser(IUser user) {
        doNothing();
    }

    @Override
    public void removeUser(IUser user) {
        doNothing();
    }

    @Override
    public void borrowBook(IBook book, IUser user) {
        doNothing();
    }

    @Override
    public void returnBook(IBook book, IUser user) {
        doNothing();
    }
}
