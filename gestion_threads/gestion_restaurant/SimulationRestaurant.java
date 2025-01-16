package gestion_threads.gestion_restaurant;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class SimulationRestaurant {
    public static void main(String[] args) {
        BlockingDeque<Commande> commandes = new LinkedBlockingDeque<>();

        Thread client1 = new Thread(new Client(commandes), "Client 1");
        Thread client2 = new Thread(new Client(commandes), "Client 2");
        Thread client3 = new Thread(new Client(commandes), "Client 3");

        Thread serveur1 = new Thread(new Serveur(commandes), "Serveur 1");
        Thread serveur2 = new Thread(new Serveur(commandes), "Serveur 2");

        client1.start();
        client2.start();
        client3.start();

        serveur1.start();
        serveur2.start();

        try {
            client1.join();
            client2.join();
            client3.join();

            serveur1.join();
            serveur2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interruption du thread principal");
        }
    }
    

    

}
