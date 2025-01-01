package interface_heritage;

public class EmployeClient extends Employe implements clientInt {
    private CompteBancaire compte;

    @Override
    public void setCompte(CompteBancaire c) {
        this.compte = c;
    }

    @Override
    public CompteBancaire getCompte() {
       return compte;
    }

    @Override
    public void Afficher() {
        super.Afficher();
        if (compte != null) {
            compte.afficher();
        }
    }
}