package gestion_bibliotheque;

public class Magazine extends Media implements Borrowable {
    private int issueNumer;
    
    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumer = issueNumber;
    }

    @Override
    public void borrow() {
        this.borrowed = true;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Magazine: " + this.title + " (" + this.year + ") #" + this.issueNumer);
    }
}