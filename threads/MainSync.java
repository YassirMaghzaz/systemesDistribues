package threads;

public class MainSync {
    public static void main(String[] args) {
        int n = 5; 
        int[] tableau = new int[n]; 

        ProducteurSync producteur = new ProducteurSync(n, tableau);
        
        ConsommateurSync consommateur = new ConsommateurSync(n, tableau, producteur);
        
        producteur.start();
        consommateur.start();
        
    }
}
