package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class HelloClient {
    public static void main(String[] args) {
        try {
            // Connexion au registre RMI sur localhost et le port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            // Recherche de l'objet distant dans le registre
            HelloInterface stub = (HelloInterface) registry.lookup("Hello");
            // Invocation de la méthode distante sayHello
            String response = stub.sayHello();
            System.out.println("Réponse du serveur : " + response);
        } catch (Exception e) {
            System.err.println("Erreur du client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
