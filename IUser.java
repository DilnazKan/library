package entities.interfaces;

import java.util.ArrayList;

public interface IUser {
    int getID();
    String getName();
    boolean isStaff();

    ArrayList<IBook> getBorrowedBooks();
}
