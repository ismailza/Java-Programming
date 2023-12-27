package Controles.controle_21_01_2021;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private final String name;
    private final List<Etudiant> etudiants;

    public Promotion(String name) {
        this.name = name;
        this.etudiants = new ArrayList<>();
    }

    public void addEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void printEtudiantResultats() {
        System.out.println(name);
        for (Etudiant etudiant : etudiants)
            etudiant.printResultats();
        System.out.println("Nombre d'étudiants ayant validé : " + compteurEtudiantValides());
    }

    public int compteurEtudiantFiltres(Predicat<Etudiant> predicat) {
        int count = 0;
        for (Etudiant etudiant : etudiants)
            if (predicat.test(etudiant))
                count++;
        return count;
    }

    public int compteurEtudiantValides() {
        return compteurEtudiantFiltres(new CritereNoteMinimale(10));
    }
}
