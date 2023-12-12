package TP1.Exercice3;

import java.util.Vector;

public class Bibliotheque {
    private int capacite;
    Vector<Livre> livres;

    Bibliotheque(int capacite) {
        this.capacite = capacite;
        livres = new Vector<>();
    }

    public int capacite() {return capacite;}

    public boolean ajouterLivre(Livre livre) {
        if (this.size() == capacite)
            return false;
        if (!livres.add(livre))
            return false;
        capacite--;
        return true;
    }

    public int size() {
        return livres.size();
    }

    public Vector<Livre> cherche(String auteur) {
        Vector<Livre> livres = new Vector<>();
        for (Livre livre : this.livres) {
            if (livre.isAuteur(auteur))
                livres.add(livre);
        }
        return livres;
    }

    @Override
    public String toString() {
        return "Bibliotheque:" +
                "\n\tcapacite: " + capacite +
                ",\n\tlivres: " + livres
                ;
    }
}
