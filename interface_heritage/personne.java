package interface_heritage;

public class personne implements personneInt {
    private String nom;
    private String prenom;
    private String adresse;

    @Override
    public void Afficher() {
        System.out.println("Nom: "+nom+", Prénom: "+prenom+", Adresse: "+adresse);

    }

    @Override
    public void setNom(String Nom) {
        this.nom = Nom;
    }

    @Override
    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    @Override
    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }
}
