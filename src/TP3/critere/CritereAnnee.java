package TP3.critere;

import TP3.model.Voiture;

public class CritereAnnee implements Critere {
    private int annee;

    public CritereAnnee(int annee) {
        this.annee = annee;
    }
    @Override
    public boolean estSatisfaitPar(Voiture voiture) {
        return this.annee == voiture.getAnnee();
    }
}
