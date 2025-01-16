package sockets.examen;

import java.io.*;
import java.net.*;

public class ConversionServer {
    private static final int SERVER_PORT = 9876;
    private static final double TAUX_DOLLAR_VERS_MAD = 9.95;
    private static final double TAUX_MAD_VERS_DOLLAR = 1 / 9.95;
    private static final double COMMISSION = 0.10;

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(SERVER_PORT)) {
            System.out.println("Le serveur de conversion est en cours d'exécution sur le port " + SERVER_PORT + "...");

            while (true) {
                try (Socket clientSocket = ss.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Un client vient de se connecter");

                    String conversionType = in.readLine();
                    System.out.println("Type de conversion reçu : " + conversionType);

                    String montantStr = in.readLine();
                    double montant;
                    try {
                        montant = Double.parseDouble(montantStr);
                        System.out.println("Montant reçu : " + montant);
                    } catch (NumberFormatException e) {
                        System.err.println("Montant invalide reçu : " + montantStr);
                        out.println("Erreur : Montant invalide.");
                        continue;
                    }

                    double montantCorrespondant = 0;
                    if ("1".equals(conversionType)) {
                        montantCorrespondant = montant * TAUX_DOLLAR_VERS_MAD;
                    } else if ("2".equals(conversionType)) {
                        montantCorrespondant = montant * TAUX_MAD_VERS_DOLLAR;
                    } else {
                        System.err.println("Type de conversion invalide : " + conversionType);
                        out.println("Erreur : Type de conversion invalide.");
                        continue;
                    }

                    double commission = montantCorrespondant * COMMISSION;
                    double montantFinal = montantCorrespondant - commission;

                    out.println(montantCorrespondant);
                    out.println(commission);
                    out.println(montantFinal);

                    System.out.println("Résultats envoyés au client :");
                    System.out.println("Montant correspondant : " + montantCorrespondant);
                    System.out.println("Commission : " + commission);
                    System.out.println("Montant final : " + montantFinal);
                } catch (IOException e) {
                    System.err.println("Erreur dans le traitement du client : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du démarrage du serveur : " + e.getMessage());
        }
    }
}
