package threads;

import java.util.Scanner;

class Producteur extends Thread {

    int n;
    int[] tableau;

    public Producteur(int n, int[] tableau) {
        this.n = n;
        this.tableau = tableau;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Entrez" + n + " nombres :");

            for (int i = 0; i< n; i++) {
                System.out.print("Nombre" + (i + 1) + ": ");
                tableau[i] = scanner.nextInt();
            }
        }
        System.out.println("Tableau final produit :");
        for (int val: tableau) {
            System.out.print(val + " ");
        }

        System.out.println();
    }

}