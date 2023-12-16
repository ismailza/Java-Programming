package TP2BIS;

import java.io.Serializable;

public class Chambre implements Serializable {
    private int num;
    private int categorie;
    private float prix;
    private int capacite;
    private char etat;

    Chambre(int num, int categorie, float prix, int capacite) {
        this.num = num;
        this.categorie = categorie;
        this.prix = prix;
        this.capacite = capacite;
        this.etat = 'L';
    }
    Chambre(int num, int categorie, float prix, int capacite, char etat) {
        this.num = num;
        this.categorie = categorie;
        this.prix = prix;
        this.capacite = capacite;
        this.etat = etat;
    }

    public int getNum() {
        return num;
    }

    public int getCategorie() {
        return categorie;
    }

    public int getCapacite() {
        return capacite;
    }

    public float getPrix() {
        return prix;
    }

    public char getEtat() {
        return etat;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "num: " + num +
                ", categorie: " + categorie +
                ", prix: " + prix +
                ", capacite: " + capacite +
                ", etat: " + (etat == 'L' ? "Libre" : "Occupée");
    }
}
