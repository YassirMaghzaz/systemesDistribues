package sockets.client_serveur;

import java.io.*;
import java.net.*;

public class SimpleServer {
    private static final int PORT = 9876;
    
    public static void main (String[] args) throws IOException {
        try (ServerSocket SS = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while(true) {
                try (Socket s = SS.accept();
                BufferedReader in = new BufferedReader( new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
                    System.out.println("Client connected");
                    String message = in.readLine();
                    System.out.println("Message reçu : "+ message);
                    out.println("Message reçu par le serveur : "+ message);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur du serveur: " + e.getMessage());
        }
    }
}
