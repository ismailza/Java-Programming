package TP3.critere;

import TP3.model.Voiture;

public class CriterePrix implements Critere {
    private float prix;

    public CriterePrix(float prix) {
        this.prix = prix;
    }

    @Override
    public boolean estSatisfaitPar(Voiture voiture) {
        return voiture.getPrixLocation() <= this.prix;
    }
}
