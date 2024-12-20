package threads;

public class ConsommateurSync extends Thread {
    int[] tableau;
    int n;
    int nbreLus = 0;

    ProducteurSync producteur;

    public ConsommateurSync(int n, int[] tableau, ProducteurSync producteur) {
        this.n = n;
        this.tableau = tableau;
        this.producteur = producteur;
    }

    @Override
    public synchronized void run() {
        while(nbreLus < n) {
            if (nbreLus >= producteur.nbreEcrits) {
                try {
                    this.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Valeur consomée : "+ tableau[nbreLus]);
                nbreLus++;
            }
            
        }
    }
}
