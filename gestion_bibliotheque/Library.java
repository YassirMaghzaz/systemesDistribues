package gestion_bibliotheque;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("The Lord of the Rings", 1954, "J.R.R. Tolkien");
        Magazine magazine = new Magazine("National Geographic", 1888, 1);
        DVD dvd = new DVD("Inception", 2010, 148);

        book.displayInfo();
        magazine.displayInfo();
        dvd.displayInfo();

        book.borrow();
        dvd.borrow();

        book.displayInfo();
        dvd.displayInfo();
        magazine.displayInfo();
    }
}
