package Controles.controle_30_01_2014;

import java.util.Date;

public abstract class Employe {
    protected String nom, prenom;
    protected int age;
    protected Date date_embauche;

    public Employe(String nom, String prenom, int age, Date date_embauche) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date_embauche = date_embauche;
    }
    public String nom() {
        return nom;
    }
    public String getNom() {
        return "L'employé " + prenom + " " + nom;
    }

    public abstract double calculerSalaire();
}
