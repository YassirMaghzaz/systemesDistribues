package gestion_bibliotheque;

public class DVD extends Media implements Borrowable {
    private int duration;
    
    public DVD(String title, int year, int duration){
        super(title, year);
        this.duration = duration;
    }

    @Override
    public void borrow() {
        this.borrowed = true;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD: " + this.title + " (" + this.year + ") - " + this.duration + " minutes");
    }
}
