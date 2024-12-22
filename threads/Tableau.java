package threads;

class Tableau {
   int[] tableau;
   int taille;
   int nbreEcrits = 0;
   
   public Tableau(int taille) {
    this.taille = taille;
    this.tableau = new int[taille];
   }

   public synchronized void ecrire(String nomProducteur, int valeur) throws InterruptedException {
    while (nbreEcrits >= taille) {
        wait();
    }
    tableau[nbreEcrits++] = valeur;
    System.out.println(nomProducteur + "a produit : "+ valeur);
    notifyAll();
   }

   public synchronized int lire() throws InterruptedException {
    while (nbreEcrits <= 0) {
        wait();
    }
    int valeur = tableau[--nbreEcrits];

    notifyAll();
    return valeur;
   }
}
