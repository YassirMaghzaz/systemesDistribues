package gestion_bibliotheque;

public abstract class  Media {
    protected String title;
    protected int year;
    protected boolean borrowed;

    public Media(String title, int year) {
        this.title = title;
        this.year = year;
        this.borrowed = false;
    }

    public abstract void displayInfo();
}