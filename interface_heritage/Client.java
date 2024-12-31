package interface_heritage;

public class Client extends personne implements clientInt {
    private CompteBancaire compte;

    @Override
    public void setCompte(CompteBancaire c) {
        this.compte = c;
    }

    @Override
    public void Afficher() {
        super.Afficher();
        if (compte != null) {
            System.out.println("Compte: " + compte.afficher());
        }
    }
}