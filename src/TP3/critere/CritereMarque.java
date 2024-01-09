package TP3.critere;

import TP3.model.Voiture;

public class CritereMarque implements Critere {
    private String marque;

    public CritereMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public boolean estSatisfaitPar(Voiture voiture) {
        return voiture.getMarque().contains(this.marque);
    }
}
