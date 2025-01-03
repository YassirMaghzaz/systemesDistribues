package sockets.question2;

import java.net.*;
import java.io.*;

public class ServeurIllimite {
    public static void main(String[] args) throws IOException {
        ServerSocket SS = new ServerSocket(5500);
        System.out.println("Serveur en attente de connexion");
        Socket S = SS.accept();
        System.out.println("Connexion établie"); 
        BufferedReader in = new BufferedReader(new InputStreamReader(S.getInputStream()));
        PrintWriter out = new PrintWriter(S.getOutputStream(), true);

        while(true){
            String message = in.readLine();
            if(message.equalsIgnoreCase("fin")) {
                System.out.println("Fin de la conversation.");
                break;}
            System.out.println("Client : "+ message);
            out.println("Message reçu");
        }

        S.close();
        SS.close();
    }
}