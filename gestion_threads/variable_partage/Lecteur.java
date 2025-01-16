package gestion_threads.variable_partage;

public class Lecteur extends Thread {

    private Tableau tab;
    
    public Lecteur(Tableau T){
        tab = T;
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            tab.Lire();
        }
    }

    public static void main(String[] args) {
       int tabEntiers[] = new int[10];
       for (int i = 0; i < 10; i++) {
           tabEntiers[i] = i;
       }

       Tableau T = new Tableau(tabEntiers);

       Thread L1 = new Lecteur(T);
       Thread L2 = new Lecteur(T);
       
       L1.start();
       L2.start();
    
    }
}
