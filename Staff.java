import entities.interfaces.IBook;

import java.util.ArrayList;

public class Staff extends Student {
    public Staff(int id, String name) {
        super(id, name);
    }

    public Staff(int id, String name, ArrayList<IBook> borrowedBooks) {
        super(id, name, borrowedBooks);
    }

    @Override
    public boolean isStaff() {
        return true;
    }
}
