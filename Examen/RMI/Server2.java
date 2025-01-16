package Examen.RMI;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;

public class Server2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
           
            Servant1 servant1 = new Servant1();
            registry.rebind("Servant1", servant1);

            Servant2 servant2 = new Servant2();
            registry.rebind("Servant2", servant2);
            
            Servant1Interface servantAssister1 = (Servant1Interface) registry.lookup("Servant1");
            Servant2Interface servantAssister2 = (Servant2Interface) registry.lookup("Servant2");

            Servant3 servant3 = new Servant3(servantAssister1, servantAssister2);
            registry.rebind("Servant3", servant3);

            System.out.println("Serveur S2 en cours d'exécution...");
        } catch (IOException | NotBoundException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
            e.printStackTrace();
        } 
    }    
}
