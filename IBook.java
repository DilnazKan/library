package entities.interfaces;

public interface IBook {
    int getISBN();
    String getTitle();
    String getAuthor();
    int getYear();
    String getGenre();
    int getCount();  // Количество книг в библиотеке если получить с помощью Library.getBooks()
    // Если книга в User.borrowedBooks, то возвращается количество книг, которые находятся у пользователя

    boolean isStaffOnly();
}
