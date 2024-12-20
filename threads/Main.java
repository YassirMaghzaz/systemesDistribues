package threads;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Entrez la taille du tableau (n) : ");
            int n = scanner.nextInt();

            int[] tableau = new int[n];

            Producteur producteur = new Producteur(n, tableau);
            Consommateur consommateur = new Consommateur(n, tableau);

            producteur.start();
            try {
                producteur.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consommateur.start();
        }


    }
}