package interface_heritage;

public class Employe extends personne implements EmployeInt {
    private String fonction;
    private double salaire;

    @Override
    public void setFonction(String f) {
        this.fonction = f;
    }

    @Override
    public void setSalaire(double s) {
        this.salaire = s;
    }

    @Override
    public void Afficher() {
        super.Afficher();
        System.out.println("Fonction: "+ fonction+ ", Salaire: "+ salaire);
    }

    @Override
    public String getFonction() {
        return fonction;
    }

    @Override
    public double getSalaire() {
        return salaire;
    }
}
