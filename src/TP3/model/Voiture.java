package TP3.model;

import java.io.Serializable;

public class Voiture implements Serializable {
    private String matricule;
    private String marque;
    private String model;
    private int annee;
    private float prixLocation;

    public Voiture(String matricule, String marque, String model, int annee, float prixLocation) {
        this.matricule = matricule;
        this.marque = marque;
        this.model = model;
        this.annee = annee;
        this.prixLocation = prixLocation;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getModel() {
        return model;
    }

    public int getAnnee() {
        return annee;
    }

    public float getPrixLocation() {
        return prixLocation;
    }

    @Override
    public String toString() {
        return "Matricule : " + matricule +
                " , Marque : " + marque +
                " , Model" + model +
                " , Année : " + annee +
                " , Prix de location : " + prixLocation;
    }
}
