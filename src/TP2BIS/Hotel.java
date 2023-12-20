package TP2BIS;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel implements Serializable {
    private static final Scanner sc = new Scanner(System.in);
    private int numSeq;
    private Vector<Chambre> chambres;

    Hotel() {
        this.numSeq = 0;
        this.chambres = new Vector<>();
    }

    public void ajouterChambre() {
        int categorie, capacite;
        float prix;
        System.out.print("Categorie : ");
        categorie = sc.nextInt();
        do {
            System.out.print("Prix : ");
            prix = sc.nextFloat();
            if (prix <= 0)
                System.out.println("Le prix doit etre un nombre positive!");
        } while (prix <= 0);
        do {
            System.out.print("Capacite : ");
            capacite = sc.nextInt();
            if (capacite < 1 || 4 < capacite)
                System.out.println("La capacite doit etre entre 1 et 4!");
        } while (capacite < 1 || 4 < capacite);
        this.chambres.add(new Chambre(++numSeq, categorie,prix, capacite));
    }

    public void ajouterChambre(Chambre chambre) {
        this.chambres.add(chambre);
    }

    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }

    public void trieParNumero() {
        chambres.sort(Comparator.comparingInt(Chambre::getNum));
    }
    public void trieParCapacite() {
        chambres.sort(Comparator.comparingInt(Chambre::getCapacite));
    }

    public void trieParCategorie() {
        chambres.sort(Comparator.comparingInt(Chambre::getCategorie));
    }
    public void trieParPrix() {
        chambres.sort(Comparator.comparingDouble(Chambre::getPrix));
    }

    public void afficherParCategorie(int categorie) {
        chambres.stream().filter(chambre -> chambre.getCategorie() == categorie)
                .forEachOrdered(System.out::println);
    }

    public void afficherParEtat(char etat) {
        chambres.stream().filter(chambre -> chambre.getEtat() == etat)
                .forEach(System.out::println);
    }

    public Vector<Chambre> getChambreCategorie(int cat) {
        Vector<Chambre> chambresCategorie = new Vector<>();
        for (Chambre chambre : chambres)
            if (chambre.getCategorie() == cat)
                chambresCategorie.add(chambre);
        return chambresCategorie;
    }

    public boolean modifierChambre(int num) {
        for (Chambre chambre : chambres)
            if (chambre.getNum() == num) {
                int categorie, capacite;
                float prix;
                System.out.print("Categorie ");
                categorie = sc.nextInt();
                do {
                    System.out.print("Prix : ");
                    prix = sc.nextFloat();
                    if (prix <= 0)
                        System.out.println("Le prix doit etre un nombre positive!");
                } while (prix <= 0);
                do {
                    System.out.print("Capacite : ");
                    capacite = sc.nextInt();
                    if (capacite < 1 || 4 < capacite)
                        System.out.println("La capacite doit etre entre 1 et 4!");
                } while (capacite < 1 || 4 < capacite);
                chambre.setCategorie(categorie);
                chambre.setCapacite(capacite);
                chambre.setPrix(prix);
                return true;
            }
        return false;
    }

    public boolean supprimerChambre(int num) {
        for (Chambre chambre : chambres)
            if (chambre.getNum() == num) {
                chambres.remove(chambre);
                return true;
            }
        return false;
    }

    public boolean changerEtatChambre(int num, char etat) {
        for (Chambre chambre : chambres)
            if (chambre.getNum() == num) {
                chambre.setEtat(etat);
                return true;
            }
        return false;
    }

    public float recetteMaximaleJournalier() {
        float recette = 0;
        for (Chambre chambre : chambres)
            recette += chambre.getPrix();
        return recette;
    }

    public float recetteRelle() {
        float recette = 0;
        for (Chambre chambre : chambres)
            if (chambre.getEtat() == 'O')
                recette += chambre.getPrix();
        return recette;
    }

    @Override
    public String toString() {
        return "Seq : " + numSeq +
                "\n\t" + chambres.stream().map(Chambre::toString).collect(Collectors.joining("\n\t"));
    }
}
