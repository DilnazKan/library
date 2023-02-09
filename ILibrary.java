import entities.interfaces.IBook;
import entities.interfaces.IUser;

import java.util.ArrayList;

public interface ILibrary {
    ArrayList<IBook> getBooks();
    IBook getBook(int isbn);
    void addBook(IBook book);
    void updateBook(IBook book);
    void removeBook(IBook book);

    ArrayList<IUser> getUsers();
    IUser getUser(int id);
    void addUser(IUser user);
    void updateUser(IUser user);
    void removeUser(IUser user);

    void borrowBook(IBook book, IUser user);
    void returnBook(IBook book, IUser user);
}
