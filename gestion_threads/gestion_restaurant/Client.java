package gestion_threads.gestion_restaurant;

import java.util.concurrent.BlockingQueue;

public class Client implements Runnable {
    private final BlockingQueue<Commande> commandes;

    public Client(BlockingQueue<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public void run() {
        try {
            Commande commande = new Commande();
            System.out.println(Thread.currentThread().getName() + " a passé la commande " + commande.getId());
            commandes.put(commande);
            System.out.println(Thread.currentThread().getName() + " attend la commande " + commande.getId());
            // Attente de la commande simulée
            Thread.sleep(1000);
        }   catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " a été interrompu");
        }
    }
}
