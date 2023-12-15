package TP1.Exercice3;

import java.io.Serializable;
import java.util.Vector;
import java.util.stream.Collectors;

public class Bibliotheque implements Serializable {
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

    public Vector<Livre> chercherParISBN(String ISBN) {
        Vector<Livre> livres = new Vector<>();
        for (Livre livre : this.livres) {
            if (livre.getISBN().startsWith(ISBN))
                livres.add(livre);
        }
        return livres;
    }

    public Vector<Livre> chercherParTitre(String titre) {
        Vector<Livre> livres = new Vector<>();
        for (Livre livre : this.livres) {
            if (livre.getTitre().startsWith(titre))
                livres.add(livre);
        }
        return livres;
    }
    public Vector<Livre> chercherParAuteur(String auteur) {
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
                "\n\tCapacité : " + capacite +
                "\n\t" + livres.stream().map(Livre::toString).collect(Collectors.joining("\n\t"));
    }
}
