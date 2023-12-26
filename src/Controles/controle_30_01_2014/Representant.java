package Controles.controle_30_01_2014;

import java.util.Date;

public class Representant extends Employe {
    protected double chiffre_affaire;

    public Representant(String nom, String prenom, int age, Date date_embauche) {
        super(nom, prenom, age, date_embauche);
        this.chiffre_affaire = 0;
    }
    public Representant(String nom, String prenom, int age, Date date_embauche, double chiffre_affaire) {
        super(nom, prenom, age, date_embauche);
        this.chiffre_affaire = chiffre_affaire;
    }

    @Override
    public String getNom() {
        return "Le représentant " + prenom + " " + nom;
    }

    public void setChiffre_affaire(double chiffre_affaire) {
        this.chiffre_affaire = chiffre_affaire;
    }

    @Override
    public double calculerSalaire() {
        return 1200 + 0.2 * chiffre_affaire;
    }
}
