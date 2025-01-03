package sockets.question3;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket S = new Socket("localhost", 5500);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(S.getInputStream()));
        PrintWriter out = new PrintWriter(S.getOutputStream(), true);

        System.out.println("Connexion établie");

        System.out.println("Entrez un message (ou 'fin' pour terminer) :");
        while(true){
            String message = userInput.readLine();
            out.println(message);
            if(message.equalsIgnoreCase("fin")) break;
            System.out.println("Serveur : "+ in.readLine());
        }
        System.out.println("Fin de la connexion");
        S.close();
    }
}