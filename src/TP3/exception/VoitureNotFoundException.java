package TP3.exception;

import TP3.model.Voiture;

public class VoitureNotFoundException extends Exception {
    public VoitureNotFoundException(Voiture voiture) {
        super("La voiture : " + voiture + " n'existe pas!");
    }
}
