package interface_heritage;

import java.util.Scanner;

public class GestionBancaire {
    public static void main(String[] args) {
        Client[] ListeClients = new Client[100];
        Employe[] ListeEmployes = new Employe[100];
        EmployeClient[] ListeEmployeClients = new EmployeClient[100];
        int nbrClientsInscrits = 0, nbrEmployesInscrits = 0, nbrEmployeClientsInscrits = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestion des Clients");
            System.out.println("2. Gestion des Employés");
            System.out.println("3. Gestion des Employés-Clients");
            System.out.println("4. Transformation des Entités");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();

            if (choix == 5) {
                System.out.println("Merci d'avoir utilisé l'application !");
                break;
            }

            switch (choix) {
                case 1:
                    gestionClients(ListeClients, nbrClientsInscrits, scanner);
                    break;
                case 2:
                    gestionEmployes(ListeEmployes, nbrEmployesInscrits, scanner);
                    break;
                case 3:
                    gestionEmployeClients(ListeEmployeClients, nbrEmployeClientsInscrits, scanner);
                    break;
                case 4:
                    transformationEntites(ListeClients, nbrClientsInscrits, ListeEmployes, nbrEmployesInscrits,
                            ListeEmployeClients, nbrEmployeClientsInscrits, scanner);
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        scanner.close();
    }

    // Méthode pour gérer les clients
    private static void gestionClients(Client[] ListeClients, int nbrClientsInscrits, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestion des Clients ---");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Modifier un client");
            System.out.println("3. Afficher les clients");
            System.out.println("4. Supprimer un client");
            System.out.println("5. Retour au menu principal");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();

            if (choix == 5)
                break;

            switch (choix) {
                case 1:
                    if (nbrClientsInscrits < ListeClients.length) {
                        Client client = new Client();
                        scanner.nextLine(); // Consommer le saut de ligne
                        System.out.print("Nom : ");
                        client.setNom(scanner.nextLine());
                        System.out.print("Prénom : ");
                        client.setPrenom(scanner.nextLine());
                        System.out.print("Adresse : ");
                        client.setAdresse(scanner.nextLine());
                        System.out.println("Création d'un compte bancaire...");
                        CompteBancaire compte = new CompteBancaire();
                        System.out.print("Numéro de compte : ");
                        compte.setNumeroCompte(scanner.nextInt());
                        System.out.print("Solde initial : ");
                        compte.setSolde(scanner.nextDouble());
                        client.setCompte(compte);
                        ListeClients[nbrClientsInscrits++] = client;
                        System.out.println("Client ajouté avec succès !");
                    } else {
                        System.out.println("Liste des clients pleine !");
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'indice du client à modifier : ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < nbrClientsInscrits) {
                        Client client = ListeClients[index];
                        scanner.nextLine(); // Consommer le saut de ligne
                        System.out.print("Nom (" + client.getNom() + ") : ");
                        client.setNom(scanner.nextLine());
                        System.out.print("Prénom (" + client.getPrenom() + ") : ");
                        client.setPrenom(scanner.nextLine());
                        System.out.print("Adresse (" + client.getAdresse() + ") : ");
                        client.setAdresse(scanner.nextLine());
                        System.out.println("Client modifié avec succès !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Liste des Clients ---");
                    for (int i = 0; i < nbrClientsInscrits; i++) {
                        System.out.print((i + 1) + ". ");
                        ListeClients[i].Afficher();
                    }
                    break;
                case 4:
                    System.out.print("Entrez l'indice du client à supprimer : ");
                    index = scanner.nextInt();
                    if (index >= 0 && index < nbrClientsInscrits) {
                        for (int i = index; i < nbrClientsInscrits - 1; i++) {
                            ListeClients[i] = ListeClients[i + 1];
                        }
                        ListeClients[--nbrClientsInscrits] = null;
                        System.out.println("Client supprimé avec succès !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void gestionEmployes(Employe[] ListeEmployes, int nbrEmployesInscrits, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestion des Employés ---");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Modifier un employé");
            System.out.println("3. Afficher les employés");
            System.out.println("4. Supprimer un employé");
            System.out.println("5. Retour au menu principal");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();

            if (choix == 5)
                break;

            switch (choix) {
                case 1:
                    if (nbrEmployesInscrits < ListeEmployes.length) {
                        Employe employe = new Employe();
                        scanner.nextLine(); // Consommer le saut de ligne
                        System.out.print("Nom : ");
                        employe.setNom(scanner.nextLine());
                        System.out.print("Prénom : ");
                        employe.setPrenom(scanner.nextLine());
                        System.out.print("Adresse : ");
                        employe.setAdresse(scanner.nextLine());
                        System.out.print("Fonction : ");
                        employe.setFonction(scanner.nextLine());
                        System.out.print("Salaire : ");
                        employe.setSalaire(scanner.nextDouble());
                        ListeEmployes[nbrEmployesInscrits++] = employe;
                        System.out.println("Employé ajouté avec succès !");
                    } else {
                        System.out.println("Liste des employés pleine !");
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'indice de l'employé à modifier : ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < nbrEmployesInscrits) {
                        Employe employe = ListeEmployes[index];
                        scanner.nextLine(); // Consommer le saut de ligne
                        System.out.print("Nom (" + employe.getNom() + ") : ");
                        employe.setNom(scanner.nextLine());
                        System.out.print("Prénom (" + employe.getPrenom() + ") : ");
                        employe.setPrenom(scanner.nextLine());
                        System.out.print("Adresse (" + employe.getAdresse() + ") : ");
                        employe.setAdresse(scanner.nextLine());
                        System.out.print("Fonction (" + employe.getFonction() + ") : ");
                        employe.setFonction(scanner.nextLine());
                        System.out.print("Salaire (" + employe.getSalaire() + ") : ");
                        employe.setSalaire(scanner.nextDouble());
                        System.out.println("Employé modifié avec succès !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Liste des Employés ---");
                    for (int i = 0; i < nbrEmployesInscrits; i++) {
                        System.out.print((i + 1) + ". ");
                        ListeEmployes[i].Afficher();
                    }
                    break;
                case 4:
                    System.out.print("Entrez l'indice de l'employé à supprimer : ");
                    index = scanner.nextInt();
                    if (index >= 0 && index < nbrEmployesInscrits) {
                        for (int i = index; i < nbrEmployesInscrits - 1; i++) {
                            ListeEmployes[i] = ListeEmployes[i + 1];
                        }
                        ListeEmployes[--nbrEmployesInscrits] = null;
                        System.out.println("Employé supprimé avec succès !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void gestionEmployeClients(EmployeClient[] ListeEmployeClients, int nbrEmployeClientsInscrits,
            Scanner scanner) {
        while (true) {
            System.out.println("\n--- Gestion des Employés-Clients ---");
            System.out.println("1. Ajouter un employé-client");
            System.out.println("2. Modifier un employé-client");
            System.out.println("3. Afficher les employés-clients");
            System.out.println("4. Supprimer un employé-client");
            System.out.println("5. Retour au menu principal");
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();

            if (choix == 5)
                break;

            switch (choix) {
                case 1:
                    if (nbrEmployeClientsInscrits < ListeEmployeClients.length) {
                        EmployeClient employeClient = new EmployeClient();
                        scanner.nextLine(); // Consommer le saut de ligne
                        System.out.print("Nom : ");
                        employeClient.setNom(scanner.nextLine());
                        System.out.print("Prénom : ");
                        employeClient.setPrenom(scanner.nextLine());
                        System.out.print("Adresse : ");
                        employeClient.setAdresse(scanner.nextLine());
                        System.out.print("Fonction : ");
                        employeClient.setFonction(scanner.nextLine());
                        System.out.print("Salaire : ");
                        employeClient.setSalaire(scanner.nextDouble());
                        System.out.println("Création d'un compte bancaire...");
                        CompteBancaire compte = new CompteBancaire();
                        System.out.print("Numéro de compte : ");
                        compte.setNumeroCompte(scanner.nextInt());
                        System.out.print("Solde initial : ");
                        compte.setSolde(scanner.nextDouble());
                        employeClient.setCompte(compte);
                        ListeEmployeClients[nbrEmployeClientsInscrits++] = employeClient;
                        System.out.println("Employé-client ajouté avec succès !");
                    } else {
                        System.out.println("Liste des employés-clients pleine !");
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'indice de l'employé-client à modifier : ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < nbrEmployeClientsInscrits) {
                        EmployeClient employeClient = ListeEmployeClients[index];
                        scanner.nextLine(); // Consommer le saut de ligne
                        System.out.print("Nom (" + employeClient.getNom() + ") : ");
                        employeClient.setNom(scanner.nextLine());
                        System.out.print("Prénom (" + employeClient.getPrenom() + ") : ");
                        employeClient.setPrenom(scanner.nextLine());
                        System.out.print("Adresse (" + employeClient.getAdresse() + ") : ");
                        employeClient.setAdresse(scanner.nextLine());
                        System.out.print("Fonction (" + employeClient.getFonction() + ") : ");
                        employeClient.setFonction(scanner.nextLine());
                        System.out.print("Salaire (" + employeClient.getSalaire() + ") : ");
                        employeClient.setSalaire(scanner.nextDouble());
                        System.out.println("Employé-client modifié avec succès !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Liste des Employés-Clients ---");
                    for (int i = 0; i < nbrEmployeClientsInscrits; i++) {
                        System.out.print((i + 1) + ". ");
                        ListeEmployeClients[i].Afficher();
                    }
                    break;
                case 4:
                    System.out.print("Entrez l'indice de l'employé-client à supprimer : ");
                    index = scanner.nextInt();
                    if (index >= 0 && index < nbrEmployeClientsInscrits) {
                        for (int i = index; i < nbrEmployeClientsInscrits - 1; i++) {
                            ListeEmployeClients[i] = ListeEmployeClients[i + 1];
                        }
                        ListeEmployeClients[--nbrEmployeClientsInscrits] = null;
                        System.out.println("Employé-client supprimé avec succès !");
                    } else {
                        System.out.println("Indice invalide !");
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void transformationEntites(
        Client[] ListeClients, int nbrClientsInscrits,
        Employe[] ListeEmployes, int nbrEmployesInscrits,
        EmployeClient[] ListeEmployeClients, int nbrEmployeClientsInscrits,
        Scanner scanner) {

    while (true) {
        System.out.println("\n--- Transformation d'Entités ---");
        System.out.println("1. Transformer un client en employé-client");
        System.out.println("2. Transformer un employé en employé-client");
        System.out.println("3. Transformer un employé-client en client");
        System.out.println("4. Transformer un employé-client en employé");
        System.out.println("5. Retour au menu principal");
        System.out.print("Entrez votre choix : ");
        int choix = scanner.nextInt();

        if (choix == 5) break;

        switch (choix) {
            case 1:
                System.out.print("Entrez l'indice du client à transformer : ");
                System.out.println(ListeClients[0].getNom() );
                System.out.println(nbrClientsInscrits);
                int indexClient = scanner.nextInt();
                if (indexClient >= 0 && indexClient < nbrClientsInscrits) {
                    Client client = ListeClients[indexClient];
                    EmployeClient employeClient = new EmployeClient();
                    // Copier les attributs du client vers employé-client
                    employeClient.setNom(client.getNom());
                    employeClient.setPrenom(client.getPrenom());
                    employeClient.setAdresse(client.getAdresse());
                    employeClient.setCompte(client.getCompte());
                    // Ajouter à la liste des employés-clients
                    ListeEmployeClients[nbrEmployeClientsInscrits++] = employeClient;
                    // Supprimer de la liste des clients
                    for (int i = indexClient; i < nbrClientsInscrits - 1; i++) {
                        ListeClients[i] = ListeClients[i + 1];
                    }
                    ListeClients[--nbrClientsInscrits] = null;
                    System.out.println("Le client a été transformé en employé-client !");
                } else {
                    System.out.println("Indice invalide !");
                }
                break;
            case 2:
                System.out.print("Entrez l'indice de l'employé à transformer : ");
                int indexEmploye = scanner.nextInt();
                if (indexEmploye >= 0 && indexEmploye < nbrEmployesInscrits) {
                    Employe employe = ListeEmployes[indexEmploye];
                    EmployeClient employeClient = new EmployeClient();
                    // Copier les attributs de l'employé vers employé-client
                    employeClient.setNom(employe.getNom());
                    employeClient.setPrenom(employe.getPrenom());
                    employeClient.setAdresse(employe.getAdresse());
                    employeClient.setFonction(employe.getFonction());
                    employeClient.setSalaire(employe.getSalaire());
                    // Ajouter à la liste des employés-clients
                    ListeEmployeClients[nbrEmployeClientsInscrits++] = employeClient;
                    // Supprimer de la liste des employés
                    for (int i = indexEmploye; i < nbrEmployesInscrits - 1; i++) {
                        ListeEmployes[i] = ListeEmployes[i + 1];
                    }
                    ListeEmployes[--nbrEmployesInscrits] = null;
                    System.out.println("L'employé a été transformé en employé-client !");
                } else {
                    System.out.println("Indice invalide !");
                }
                break;
            case 3:
                System.out.print("Entrez l'indice de l'employé-client à transformer en client : ");
                int indexEmployeClient = scanner.nextInt();
                if (indexEmployeClient >= 0 && indexEmployeClient < nbrEmployeClientsInscrits) {
                    EmployeClient employeClient = ListeEmployeClients[indexEmployeClient];
                    Client client = new Client();
                    // Copier les attributs de l'employé-client vers client
                    client.setNom(employeClient.getNom());
                    client.setPrenom(employeClient.getPrenom());
                    client.setAdresse(employeClient.getAdresse());
                    client.setCompte(employeClient.getCompte());
                    // Ajouter à la liste des clients
                    ListeClients[nbrClientsInscrits++] = client;
                    // Supprimer de la liste des employés-clients
                    for (int i = indexEmployeClient; i < nbrEmployeClientsInscrits - 1; i++) {
                        ListeEmployeClients[i] = ListeEmployeClients[i + 1];
                    }
                    ListeEmployeClients[--nbrEmployeClientsInscrits] = null;
                    System.out.println("L'employé-client a été transformé en client !");
                } else {
                    System.out.println("Indice invalide !");
                }
                break;
            case 4:
                System.out.print("Entrez l'indice de l'employé-client à transformer en employé : ");
                indexEmployeClient = scanner.nextInt();
                if (indexEmployeClient >= 0 && indexEmployeClient < nbrEmployeClientsInscrits) {
                    EmployeClient employeClient = ListeEmployeClients[indexEmployeClient];
                    Employe employe = new Employe();
                    // Copier les attributs de l'employé-client vers employé
                    employe.setNom(employeClient.getNom());
                    employe.setPrenom(employeClient.getPrenom());
                    employe.setAdresse(employeClient.getAdresse());
                    employe.setFonction(employeClient.getFonction());
                    employe.setSalaire(employeClient.getSalaire());
                    // Ajouter à la liste des employés
                    ListeEmployes[nbrEmployesInscrits++] = employe;
                    // Supprimer de la liste des employés-clients
                    for (int i = indexEmployeClient; i < nbrEmployeClientsInscrits - 1; i++) {
                        ListeEmployeClients[i] = ListeEmployeClients[i + 1];
                    }
                    ListeEmployeClients[--nbrEmployeClientsInscrits] = null;
                    System.out.println("L'employé-client a été transformé en employé !");
                } else {
                    System.out.println("Indice invalide !");
                }
                break;
            default:
                System.out.println("Choix invalide !");
        }
    }
}

}
