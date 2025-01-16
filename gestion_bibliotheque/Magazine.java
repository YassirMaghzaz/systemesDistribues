package gestion_bibliotheque;

public class Magazine extends Book implements Borrowable {
    int issueNumer;
    
    public void borrow() {
        this.borrowed = true;
    }
}