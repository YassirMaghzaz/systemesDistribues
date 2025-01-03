package sockets.question3;
import java.io.*;
import java.net.*;
public class ServeurMultiClient {
    public static void main (String[] args) throws IOException {
        ServerSocket SS = new ServerSocket(5500);
        System.out.println("Serveur en attente de connexion");
        while (true){
            Socket S = SS.accept();
            System.out.println("Client connecté");
            new ClientHandler(S).start();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket S;

        public ClientHandler(Socket S){
            this.S = S;
        }

        public void run(){
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(this.S.getInputStream()));
                PrintWriter out = new PrintWriter(S.getOutputStream(), true);
                while (true){
                    String message = in.readLine();
                    if (message == null || message.equalsIgnoreCase("fin"))break;
                    System.out.println("Client : " + message);
                    out.println("Message reçu");
                }
                this.S.close();
                System.out.println("Client déconnecté");

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
