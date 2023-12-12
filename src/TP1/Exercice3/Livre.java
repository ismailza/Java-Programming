package TP1.Exercice3;

import java.util.Vector;

public class Livre {
    private String ISBN;
    private String titre;
    private Vector<String> auteurs;
    private float prix;

    Livre(String ISBN, String titre, Vector<String> auteurs, float prix) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteurs = auteurs;
        this.prix = prix;
    }

    public boolean isAuteur(String auteur) {
        for (String au : auteurs) {
            if (au.toLowerCase().startsWith(auteur.toLowerCase()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN +
                ", titre: " + titre +
                ", auteurs: " + auteurs +
                ", prix: " + prix + " euro"
                ;
    }
}
