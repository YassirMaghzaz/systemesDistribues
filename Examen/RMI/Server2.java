package Examen.RMI;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;

public class Server2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);

            Servant1Interface servant1 = (Servant1Interface) registry.lookup("Servant1");
            Servant2Interface servant2 = (Servant2Interface) registry.lookup("Servant2");

            Servant3 servant3 = new Servant3(servant1, servant2);

            registry.rebind("Servant3", servant3);

            System.out.println("Serveur S2 en cours d'exécution...");
        } catch (IOException | NotBoundException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
            e.printStackTrace();
        } 
    }    
}
