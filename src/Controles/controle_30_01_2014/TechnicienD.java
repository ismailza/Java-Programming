package Controles.controle_30_01_2014;

import java.util.Date;

public class TechnicienD extends Technicien implements RiskContract {
    public TechnicienD(String nom, String prenom, int age, Date date_embauche) {
        super(nom, prenom, age, date_embauche);
    }
    public TechnicienD(String nom, String prenom, int age, Date date_embauche, int nb_unite_produit) {
        super(nom, prenom, age, date_embauche, nb_unite_produit);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + prime;
    }
}
