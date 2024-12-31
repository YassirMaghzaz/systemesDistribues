public class CompteBancaire {
    private int numeroCompte;
    private double solde;

    public void afficher() {
        System.out.println("Compte N°:" + numeroCompte + ", Solde: "+ solde);
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void depot(double montant) {
        solde += montant;
    }

    public boolean retrait(double montant) {
        if (montant <= solde) {
            solde -= montant;
            return true;
        }
        return false;
    }

    public boolean virement(CompteBancaire destinataire, double montant) {
        if (retrait(montant)) {
            destinataire.depot(montant);
            return true;
        }
        return false;
    }   
}