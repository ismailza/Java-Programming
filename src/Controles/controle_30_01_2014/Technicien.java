package Controles.controle_30_01_2014;

import java.util.Date;

public class Technicien extends Employe {
    private int nb_unite_produit;

    public Technicien(String nom, String prenom, int age, Date date_embauche) {
        super(nom, prenom, age, date_embauche);
    }
    public Technicien(String nom, String prenom, int age, Date date_embauche, int nb_unite_produit) {
        super(nom, prenom, age, date_embauche);
        this.nb_unite_produit = nb_unite_produit;
    }

    public void setNb_unite_produit(int nb_unite_produit) {
        this.nb_unite_produit = nb_unite_produit;
    }

    @Override
    public String getNom() {
        return "Le technicien " + prenom + " " + nom;
    }

    @Override
    public double calculerSalaire() {
        return 5 * nb_unite_produit;
    }
}
