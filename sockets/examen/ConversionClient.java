package sockets.examen;

import java.io.*;
import java.net.*;

public class ConversionClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Phase A : Demander le type de conversion
            String conversionType = "";
            while (!conversionType.equals("1") && !conversionType.equals("2")) {
                System.out.println("Entrez le sens de la conversion (Dollar vers MAD ou MAD vers Dollar) : ");
                String input = consoleInput.readLine();

                if ("Dollar vers MAD".equalsIgnoreCase(input)) {
                    conversionType = "1";
                } else if ("MAD vers Dollar".equalsIgnoreCase(input)) {
                    conversionType = "2";
                } else {
                    System.out.println("Saisie invalide. Veuillez réessayer.");
                }
            }
            out.println(conversionType);

            // Phase B : Demander le montant
            System.out.println("Entrez le montant à convertir : ");
            String montant = consoleInput.readLine();
            out.println(montant);

            // Phase D : Lire les résultats du serveur
            try {
                double montantCorrespondant = Double.parseDouble(in.readLine());
                double commission = Double.parseDouble(in.readLine());
                double montantFinal = Double.parseDouble(in.readLine());

                System.out.println("Montant correspondant : " + montantCorrespondant);
                System.out.println("Commission : " + commission);
                System.out.println("Montant final : " + montantFinal);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Le serveur a renvoyé une réponse invalide.");
            }

        } catch (IOException e) {
            System.err.println("Erreur au niveau du client : " + e.getMessage());
        }
    }
}
