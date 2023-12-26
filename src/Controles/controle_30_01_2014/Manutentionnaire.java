package Controles.controle_30_01_2014;

import java.util.Date;

public class Manutentionnaire extends Employe {
    private int nb_heure_travail;
    public Manutentionnaire(String nom, String prenom, int age, Date date_embauche) {
        super(nom, prenom, age, date_embauche);
        this.nb_heure_travail = 0;
    }
    public Manutentionnaire(String nom, String prenom, int age, Date date_embauche, int nb_heure_travail) {
        super(nom, prenom, age, date_embauche);
        this.nb_heure_travail = nb_heure_travail;
    }

    @Override
    public String getNom() {
        return "Le manutentionnaire " + prenom + " " + nom;
    }

    public void setNb_heure_travail(int nb_heure_travail) {
        this.nb_heure_travail = nb_heure_travail;
    }

    @Override
    public double calculerSalaire() {
        return 90 * nb_heure_travail;
    }
}
