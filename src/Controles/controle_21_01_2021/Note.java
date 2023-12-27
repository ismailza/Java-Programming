package Controles.controle_21_01_2021;

import java.util.List;

public class Note {
    private static final int MAXIMUM_NOTE = 20;
    private final double valeur;
    private final boolean absent;
    public Note() {
        this.valeur = 0;
        this.absent = true;
    }
    public Note(double valeur) throws IllegalArgumentException {
        if (valeur < 0 || MAXIMUM_NOTE < valeur)
            throw new IllegalArgumentException("Valeur de le note ("+valeur+") doit etre dans l'intervalle 0-"+MAXIMUM_NOTE);
        this.valeur = valeur;
        this.absent = false;
    }
    public Note(double valeur, boolean absent) throws IllegalArgumentException {
        if (valeur < 0 || MAXIMUM_NOTE < valeur)
            throw new IllegalArgumentException("Valeur de le note ("+valeur+") doit etre dans l'intervalle 0-"+MAXIMUM_NOTE);
        this.valeur = valeur;
        this.absent = absent;
    }

    public boolean isAbsent() {
        return absent;
    }

    public double getValeur() {
        return valeur;
    }

    public static Note noteMoyenne(List<Note> notes) {
        double sum = 0;
        boolean abs = false;
        for (Note note : notes) {
            if (note.absent)
                abs = true;
            else
                sum += note.valeur;
        }
        return new Note(sum/(double) notes.size(), abs);
    }

    @Override
    public String toString() {
        return absent ? "ABS" : valeur +"/"+MAXIMUM_NOTE;
    }
}
