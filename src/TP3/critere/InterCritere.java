package TP3.critere;

import TP3.model.Voiture;

import java.util.ArrayList;
import java.util.List;

public class InterCritere implements Critere {
    private List<Critere> criteres;

    public InterCritere() {
        this.criteres = new ArrayList<>();
    }

    public void addCritere(Critere critere) {
        this.criteres.add(critere);
    }

    @Override
    public boolean estSatisfaitPar(Voiture voiture) {
        for (Critere critere : criteres)
            if (!critere.estSatisfaitPar(voiture))
                return false;
        return true;
    }
}
