package TP3.critere;

import TP3.model.Voiture;

public interface Critere {
    /**
     * @param voiture la voiture dont on teste la confirmité
     * @return true si et seulement si la voiture est conforme au
     * critère (on dit que voiture satisfait le critère)
     */
    public boolean estSatisfaitPar(Voiture voiture);
}
