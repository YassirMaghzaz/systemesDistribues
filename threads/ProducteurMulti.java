package threads;

public class ProducteurMulti extends Thread {
    Tableau tableau;
    String nom;

    public ProducteurMulti(Tableau tableau, String nom) {
        this.tableau = tableau;
        this.nom = nom;
    }

    @Override 
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                tableau.ecrire(nom, i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
