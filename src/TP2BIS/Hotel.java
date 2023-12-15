package TP2BIS;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
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
        this.chambres.add(new Chambre(numSeq, categorie,prix, capacite));
    }

    public void trieParCapacite() {
        chambres.sort(Comparator.comparingInt(Chambre::getCapacite));
    }

    public void afficherParCategorie(int categorie) {
        chambres.stream().filter(chambre -> chambre.getCategorie() == categorie)
                .forEachOrdered(System.out::println);
    }

    @Override
    public String toString() {
        return "Hotel:" +
                "\n\t" + chambres.stream().map(Chambre::toString).collect(Collectors.joining("\n\t"));
    }
}
