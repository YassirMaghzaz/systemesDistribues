package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class HelloClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            HelloInterface stub = (HelloInterface) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("Réponse du serveur : " + response);
        } catch (Exception e) {
            System.err.println("Erreur du client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
