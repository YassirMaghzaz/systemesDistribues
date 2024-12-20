package threads;

class Consommateur extends Thread {
    int n;
    int[] tableau;

    public Consommateur(int n, int[] tableau) {
        this.n = n;
        this.tableau = tableau;
    }

    @Override
    public void run() {
        System.out.println("Consommation des données : ");
        for (int i = 0; i < n; i++) {
            System.out.println("Valeur consommée : " + tableau[i]);
        }
    }
}
