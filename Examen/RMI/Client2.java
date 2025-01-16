package Examen.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;
public class Client2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Servant1Interface servant1 = (Servant1Interface) registry.lookup("Servant1");
            Servant2Interface servant2 = (Servant2Interface) registry.lookup("Servant2");
            Servant3Interface servant3 = (Servant3Interface) registry.lookup("Servant3");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez le premier entier (m) : ");
            int m = scanner.nextInt();

            System.out.println("Entrez le deuxième entier (n) : ");
            int n = scanner.nextInt();

            int resultatSoustraction = servant1.soustraction(m, n);
            boolean estInferieur = servant2.inferieur(m, n);
            int resultatCalculReste = servant3.calculReste(m, n);
            System.out.println("Résultat de m - n : " + resultatSoustraction); 
            System.out.println("m est inférieur à n : " + estInferieur); 
            System.out.println("Résultat de m % n : " + resultatCalculReste);
        }catch (Exception e) { 
            System.err.println("Erreur du client C2 : " + e.getMessage());
            e.printStackTrace();
        }
    }    
}
