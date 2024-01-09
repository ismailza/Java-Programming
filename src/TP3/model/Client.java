package TP3.model;

import TP3.eumeration.Civilite;

import java.io.Serializable;
import java.util.Comparator;

public class Client implements Serializable {
    private String nom;
    private String prenom;
    private String CIN;
    private Civilite civilite;

    public Client(String nom, String prenom, String CIN, Civilite civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.civilite = civilite;
    }

    public String getCIN() {
        return CIN;
    }

    @Override
    public String toString() {
        return civilite + ". " + nom.toUpperCase() + " " + prenom + " | CIN : " + CIN;
    }
}
