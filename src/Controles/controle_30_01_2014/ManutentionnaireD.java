package Controles.controle_30_01_2014;

import java.util.Date;

public class ManutentionnaireD extends Manutentionnaire implements RiskContract {
    public ManutentionnaireD(String nom, String prenom, int age, Date date_embauche) {
        super(nom, prenom, age, date_embauche);
    }
    public ManutentionnaireD(String nom, String prenom, int age, Date date_embauche, int nb_heure_travail) {
        super(nom, prenom, age, date_embauche, nb_heure_travail);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + prime;
    }
}
