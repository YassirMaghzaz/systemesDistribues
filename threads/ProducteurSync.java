package threads;

import java.util.Scanner;

public class ProducteurSync extends Thread {
    int[] tableau;
    int n;
    int nbreEcrits = 0;

    public ProducteurSync(int n, int[] tableau) {
        this.n = n;
        this.tableau = tableau;
    }

    @Override
    public synchronized void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < n; i++) {
                System.out.print("Entrez une valeur : ");
                tableau[nbreEcrits] = scanner.nextInt();
                nbreEcrits++;
               // notify();
            }
        }
    }

    public synchronized boolean isTableauPlein() {
        return nbreEcrits >= n;
    }
}
