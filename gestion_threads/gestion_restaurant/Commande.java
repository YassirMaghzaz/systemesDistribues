package gestion_threads.gestion_restaurant;

public class Commande {
    private static int counter = 0;
    private final int id;

    public Commande() {
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }
}
