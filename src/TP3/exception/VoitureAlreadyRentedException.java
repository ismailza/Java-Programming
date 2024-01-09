package TP3.exception;

import TP3.model.Voiture;

public class VoitureAlreadyRentedException extends Exception {
    public VoitureAlreadyRentedException(Voiture voiture) {
        super("La voiture : " + voiture + " est déja louée!");
    }
}
