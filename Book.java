package entities;

public class Book implements IBook {
    private final int isbn;
    private final String title;
    private final String author;
    private final int year;
    private final String genre;
    private final int count;

    public Book(int isbn, String title, String author, int year, String genre, int count) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.count = count;
    }

    public int getISBN() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }


    public String getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

    public boolean isStaffOnly() {
        return false;
    }
}
