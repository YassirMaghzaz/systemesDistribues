package Examen.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server1 {
    public static void main(String[] args) {
        try {
            Servant1 servant1 = new Servant1();
            Servant2 servant2 = new Servant2();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Servant1", servant1);
            registry.rebind("Servant2", servant2);

            System.out.println("Serveur S1 en cours d'exécution...");
        } catch (Exception e) {
            System.err.println("Erreur du Serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }    
}
