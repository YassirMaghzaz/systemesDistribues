package gestion_bibliotheque;

public class Book extends Media implements Borrowable {
    private String author;

    public Book(String title, int year, String author) {
        super(title, year);
        this.author = author;
    }

    @Override
    public void borrow() {
        this.borrowed = true;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + this.title + " (" + this.year + ") by " + this.author);
    }
}