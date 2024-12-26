/*
 * Définition de Package
 */
package sockets.question1; //spécification du package auquel il appartient le fichier java

/*
 * Importation
 */
import java.io.*; // Importe les classes nécessaires pour gérer les entrées/sorties (BufferedReader, InputStreamReader, PrintWriter...)
import java.net.*; // Importe les classes pour la communication réseau (ServerSocket, Socket)

/* Fonctionnement du programme
 * Démarage du serveur : il écoute sur le port 1234
 * Connexion acceptée : le serveur accepte un client lorqu'il tente de se connecter
 * Communication :
 * Le serveur lit deux messages envoyés par le client
 * Il envoie une confirmation "Message reçu." après chaque message.
 * Terminaison :  Une fois les deux messages traités, le serveur ferme la connexion avec le client et s'arrête.
 */
public class Serveur {
    public static void main(String[] args) throws IOException {
        /*
         * Création du serveur
         */
        ServerSocket serverSocket = new ServerSocket(1234); // Créeer un serveur qui écoute sur un port 1234 - le serveur reste en attente d'une connexion d'un client
        System.out.println("Serveur en attente de connexion..."); // Afficher un message dans la console pour indiquer que le serveur est en attente de connexion

        /*
         * Atente et acceptation d'une connexion
         */
        // Object socket représente la connexion établie avec le client
        Socket socket = serverSocket.accept(); // Bloquer l'exécution jusqu'à ce qu'un client se connecte au serveur - Une fois qu'un client se connecte, retourne un objet Socket représentant cette connexion
       
        System.out.println("Connexion acceptée."); // Affiche un message indiquant qu'un client s'est connecté

        /*
         *Préparation des flux de communication
         */

        /*
         *InputStreamReader et BufferedReader permettent la communication entre le serveur et le client
         *socket.getInputStream() récupère le flux d'entée du client
         *BufferedReader Facilite la lecture de texte à partir du flux d'entrée
        */
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
        
        /*
         * PrintWriter
         * socket.getOutputStream() Récupère le flux de sortie vers le client (messages que le serveur envoie au client).
         * Le second argument true active le mode "auto-flush", ce qui envoie immédiatement les données après chaque println
         */
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        /*
         * Boucle pour lire et répondre aux messages
         */

        // Serveur lit et répond à deux messages avant de terminer
        for (int i = 0;  i < 2; i++) {
            String message = in.readLine();// Attend de recevoir une ligne de texte complète - la ligne reçue est stockée dans la variable message
            System.out.println("Mesage reçu : " + message);// Affiche le message reçu dans la console du serveur
            out.println("Message reçu.");// Envoie une Confirmation au client indiquant que le message a bien été reçu
        }

        socket.close(); // Ferme la connexion avec le clien
        serverSocket.close(); // Arrête le serveur, libérant ainsi le port 1234

    }
}