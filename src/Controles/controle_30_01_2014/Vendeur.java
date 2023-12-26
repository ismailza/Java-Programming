package Controles.controle_30_01_2014;

import java.util.Date;

public class Vendeur extends Representant {

    public Vendeur(String nom, String prenom, int age, Date date_embauche) {
        super(nom, prenom, age, date_embauche);
    }
    public Vendeur(String nom, String prenom, int age, Date date_embauche, double chiffre_affaire) {
        super(nom, prenom, age, date_embauche, chiffre_affaire);
    }

    @Override
    public String getNom() {
        return "Le vendeur " + prenom + " " + nom;
    }

    @Override
    public double calculerSalaire() {
        return 600 + 0.2 * chiffre_affaire;
    }
}
