package sockets.chat;

import java.io.*;
import java.net.*;

public class SimpleChatServer {
    private static final int PORT = 12345;
    private static Socket[] clients = new Socket[10];
    private static int clientCount = 0;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Le serveur de chat est en attente de connexions...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                synchronized (clients) {
                    if (clientCount < clients.length) {
                        clients[clientCount++] = clientSocket;
                        new ClientHandler(clientSocket, clients).start();
                    } else {
                        System.out.println("Le serveur est complet.");
                        clientSocket.close();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private Socket[] clients;

        public ClientHandler(Socket socket, Socket[] clients) {
            this.socket = socket;
            this.clients = clients;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Message reçu : " + message);
                    synchronized (clients) {
                        for (int i = 0; i < clientCount; i++) {
                            if (clients[i] != socket) {
                                PrintWriter out = new PrintWriter(clients[i].getOutputStream(), true);
                                out.println(message);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Erreur de communication : " + e.getMessage());
            }
        }
    }
}
