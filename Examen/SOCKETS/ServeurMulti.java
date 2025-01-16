package Examen.SOCKETS;

import java.io.*;
import java.net.*;

public class ServeurMulti {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try{
            ServerSocket SS = new ServerSocket(PORT);
            System.out.println("Le Serveur en écoute sur le Port "+ PORT );
            Socket S = SS.accept();
            System.out.println("Un Client vient de se connecter !");
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            
            PrintWriter out = new PrintWriter(S.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(S.getInputStream()));

            //Demander à l'utilisateur le nom du serveur
            System.out.println("Saisir le nom du serveur : ");
            String serveurNom = consoleInput.readLine();
            System.out.println("Nouveau Nom du serveur :  "+ serveurNom);
            
            String message = "";
            //Recevoir deux messages de chez l'utilisateur
           while(true) {
                message = in.readLine();
                if (!message.equalsIgnoreCase("fin")){
                    System.out.println("Message Reçu du client - "+ message);
                    String acquittement = serveurNom + " pour le message : " + message;
                    out.println(acquittement);
                } else {
                    System.out.println("Fin Program");
                    break;
                }
                
            }
            
            S.close();
            SS.close();
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        }

        
    }
}
