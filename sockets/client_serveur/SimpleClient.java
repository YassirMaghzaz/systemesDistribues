package sockets.client_serveur;

import java.io.*;
import java.net.*;

public class SimpleClient {
    private static final String HOST = "localhost";
    private static final int PORT = 9876;

    public static void main (String[] args) throws IOException {
        try (Socket socket = new Socket(HOST, PORT)){
            System.out.println("Client is running on port " + PORT);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            
            System.out.print("Entrez un message : ");
            String message = consoleInput.readLine();
            out.println(message);

            String response = in.readLine();
            System.out.println(response);
        }catch (IOException e) {
            System.err.println("Erreur du client: " + e.getMessage());
        }
    }
}
