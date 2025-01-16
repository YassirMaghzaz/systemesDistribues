package Examen.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client1 {
    public static void main (String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Servant1Interface servant1 = (Servant1Interface) registry.lookup("Servant1");
            Servant2Interface servant2 = (Servant2Interface) registry.lookup("Servant2");

            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Entrez le premier entier (m) : ");
            int m = scanner.nextInt();

            System.out.println("Entrez le deuxième entier (n) : ");
            int n = scanner.nextInt();

            int resultat = servant1.soustraction(m, n);
            boolean estInferieur = servant2.inferieur(m, n);
            
            System.out.println("Résultat de m - n : " + resultat); 
            System.out.println("m est inférieur à n : " + estInferieur); 
        } catch (Exception e) { 
            System.err.println("Erreur du client C1 : " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}