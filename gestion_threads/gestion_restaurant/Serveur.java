package gestion_threads.gestion_restaurant;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.BlockingQueue;

public class Serveur implements Runnable{
    private final BlockingQueue<Commande> commandes;

    public Serveur(BlockingQueue<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public void run() {
        try {
            while(true) {
                Commande commande = commandes.poll(2, TimeUnit.SECONDS);
                if (commande != null) {
                    System.out.println(Thread.currentThread().getName() + " n'a pas de commandes en attente.");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " a pris la commande " + commande + ".");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " a servi la commande " + commande + ".");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " a été interrompu.");
        }
    }
}
