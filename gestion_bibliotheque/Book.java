package gestion_bibliotheque;

public class Book extends Media implements Borrowable {
    String author;

    public void borrow() {
        this.borrowed = true;
    }
}