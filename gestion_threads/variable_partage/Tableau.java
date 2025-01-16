package gestion_threads.variable_partage;

public class Tableau {
    int tab[];
    int indice;
    
    public Tableau(int[] T){
        tab = T;
        indice = 0;
    }

    public synchronized void Lire() {
        System.out.println("Lu : " + tab[indice]);
        indice++;
    }
}
