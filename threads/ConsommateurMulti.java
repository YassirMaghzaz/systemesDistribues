package threads;

public class ConsommateurMulti extends Thread {
    Tableau tableau;
    public ConsommateurMulti(Tableau tableau) {
        this.tableau = tableau;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int valeur = tableau.lire();
                System.out.println("Consommateur a lu : " + valeur);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
