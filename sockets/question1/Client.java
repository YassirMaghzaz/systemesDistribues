/*
 * Définition de Package
 */
package sockets.question1;//spécification du package auquel il appartient le fichier java

/*
 * Importation
 */
import java.io.*;// Importe les classes nécessaires pour gérer les entrées/sorties (BufferedReader, InputStreamReader, PrintWriter...)
import java.net.*; // Importe les classes pour la communication réseau (ServerSocket, Socket)

/*
 * Résumé Fonctionnel
    Le client se connecte au serveur sur localhost (même machine) et le port 1234
    
    Une boucle s'exécute deux fois:
        Le client demande à l'utilisateur de saisir un message
        Le message est envoyé au serveur
        Le client reçoit et affiche la réponse du serveur
    
    Une fois les deux messages envoyés et traités, le client ferme la connexion 
 */
public class Client {
    public static void main(String[] args) throws IOException {
        /*
         * Création du client et connexion au serveur
         */
        /*
         * Socket objet qui représente une connexion réseau entre le client et le serveur - Ici, on se connecte au serveur situé sur la même machine (localhost) et qui écoute sur le port 1234
          
         *localhost : L'adresse IP pour indiquer que le serveur est exécuté localement sur la même machine

         *Une fois cette ligne exécutée, le client est connecté au serveur (si le serveur est actif)
         */
        
        Socket socket = new Socket("localhost", 1234); // Connexion au serveur

        /*
         * Préparation des flux de communication
         */
        /*
         * Configuration de canaux de communiation pour échanger des messages entre le client et le serveur
         
         *userInput:
            Permet au client de lire des entrées depuis le clavier
            System.in Représente l'entrée standard (clavier)

        *out:
            Permet d'envoyer des messages au serveur
            socket.getOutputStream() : Obtient le flux de sortie du client, qui est connecté au serveur.
            true : Active le mode "auto-flush", ce qui signifie que les messages sont envoyés immédiatement après chaque println.

        *in:
            Permet de recevoir des messages en provenance du serveur
            socket.getInputStream() : Obtient le flux d'entrée connecté au serveur
         */
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        /*
         * Boucle pour envoyer et recevoir des messages
         */
        /*
         * Boucle for
            Permet au client d'envoyer deux messages au serveur
         */
        for (int i = 0; i < 2; i++) {
            System.out.print("Entrez un message : ");

            /*
             * Etape 1 : Lecture de l'utilisateur
                Attend que l'utilisateur saisisse une ligne de texte dans le terminal
                Le texte saisi est stocké dans la variable message
             */
            String message = userInput.readLine();
            /*
             * Etape 2 : Envoi du message au serveur
                Le message saisi est envoyé au serveur via le flux de sortie out
             */
            out.println(message);
            /*
             * Etape 3 : Lecture de la réponse du serveur
                Le client attend une réponse du serveur via le flux d'entrée in
                La réponse est affichée dans la console

             */
            System.out.println("Réponse du serveur : " + in.readLine()); // Réponse du serveur
        }
        /*
         * Fermeture de la connexion
            Ferme la connexion entre le client et le serveur
            Libérer les ressources liées au socket
         */
        socket.close();
    }
}
