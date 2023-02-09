import entities.interfaces.IBook;
import entities.interfaces.IUser;

import java.util.ArrayList;

public class Student implements IUser {
    private final int id;
    private final String name;
    private final ArrayList<IBook> borrowedBooks = new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, ArrayList<IBook> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.borrowedBooks.addAll(borrowedBooks);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isStaff() {
        return false;
    }

    @Override
    public ArrayList<IBook> getBorrowedBooks() {
        return borrowedBooks;
    }
}
