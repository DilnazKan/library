package entities;

import entities.Book;

public class StaffBook extends Book {
    public StaffBook(int isbn, String title, String author, int year, String genre, int count) {
        super(isbn, title, author, year, genre, count);
    }

    @Override
    public boolean isStaffOnly() {
        return true;
    }
}
