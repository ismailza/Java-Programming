package TP3.critere;

import TP3.model.Voiture;

public class CritereModel implements Critere {
    private String model;
    public CritereModel(String model) {
        this.model = model;
    }
    @Override
    public boolean estSatisfaitPar(Voiture voiture) {
        return voiture.getModel().contains(this.model);
    }
}
