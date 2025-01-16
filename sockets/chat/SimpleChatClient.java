package sockets.chat;

import java.io.*;
import java.net.*;

public class SimpleChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            new Thread(new Reader(in)).start();

            String message;
            while ((message = consoleInput.readLine()) != null) {
                out.println(message);
            }
        } catch (IOException e) {
            System.err.println("Erreur du client : " + e.getMessage());
        }
    }

    private static class Reader implements Runnable {
        private BufferedReader in;

        public Reader(BufferedReader in) {
            this.in = in;
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Message du serveur : " + message);
                }
            } catch (IOException e) {
                System.err.println("Erreur de communication : " + e.getMessage());
            }
        }
    }
}
