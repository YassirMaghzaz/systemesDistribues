package Examen.SOCKETS;

import java.net.*;
import java.io.*;

public class ClientMulti {
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

            String message = "";
            while (true){
                System.out.println("Entrez le message : "); 
                message = consoleInput.readLine(); 
                if(!message.equalsIgnoreCase("fin")){
                    out.println(clientNom + " : " + message);

                    // Réception de l'acquittement du serveur 
                    String acquittement = in.readLine(); 
                    System.out.println("Acquittement reçu de " + acquittement);
                } else {
                    out.println(message);
                    System.out.println("Fin Programme");
                    break;
                }   
                
            }
            
            S.close();
        }catch (IOException e) {
            System.err.println("Erreur du Client : " + e.getMessage() );
        }
    }    
}
