package Controles.controle_21_01_2021;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private final String Prenom;
    private final String Nom;
    private final List<ResultatModule> resultats;

    public Etudiant(String prenom, String nom) {
        this.Prenom = prenom;
        this.Nom = nom;
        this.resultats = new ArrayList<>();
    }

    public void addResultats(String nomModule, Note note) {
        this.resultats.add(new ResultatModule(nomModule, note));
    }

    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        for (ResultatModule resultat : resultats)
            notes.add(resultat.getNote());
        return notes;
    }

    public Note noteMoyenne() {
        return Note.noteMoyenne(this.getNotes());
    }

    public void printResultats() {
        System.out.print(Prenom + " " + Nom);
        for (ResultatModule resultat : resultats)
            System.out.print(" " + resultat);
        System.out.println(" Note moyenne : " + this.noteMoyenne());
    }
}
