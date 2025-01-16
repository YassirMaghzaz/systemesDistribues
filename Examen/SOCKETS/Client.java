package Examen.SOCKETS;

import java.net.*;
import java.io.*;

public class Client {
    private static final int PORT = 9876;
    public static void main(String[] args) throws IOException{
        try{
            Socket S = new Socket("localhost", PORT);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(S.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(S.getInputStream()));

            System.out.println("Entrez votre nom : "); 
            String clientNom = consoleInput.readLine();
            System.out.println("Nouveau Nom du client :  "+ clientNom);

            // Premier message 
            System.out.println("Entrez le premier message : "); 
            String premierMessage = consoleInput.readLine(); 
            out.println(clientNom + " : " + premierMessage);

            // Réception de l'acquittement du serveur 
            String acquittement1 = in.readLine(); 
            System.out.println("Acquittement reçu de " + acquittement1); 

            // Deuxième message 
            System.out.println("Entrez le deuxième message : "); 
            String deuxiemeMessage = consoleInput.readLine(); 
            out.println(clientNom + " : " + deuxiemeMessage); 

            // Réception de l'acquittement du serveur 
            String acquittement2 = in.readLine(); 
            System.out.println("Acquittement reçu de  " + acquittement2);

            S.close();
        }catch (IOException e) {
            System.err.println("Erreur du Client : " + e.getMessage() );
        }
    }    
}
