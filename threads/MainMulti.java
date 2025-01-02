package threads;

public class MainMulti {
    public static void main(String[] args) {
        Tableau tableau = new Tableau(10);

        ProducteurMulti producteur1 = new ProducteurMulti(tableau, "Producteur 1");
        ProducteurMulti producteur2 = new ProducteurMulti(tableau, "Producteur 2");

        ConsommateurMulti consommateur = new ConsommateurMulti(tableau);

        producteur1.start();
        producteur2.start();
        consommateur.start();

        // try {
        //     producteur1.join();
        //     producteur2.join();
        //     consommateur.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        System.out.println("Tous les threads ont terminé !");
    }
}   
