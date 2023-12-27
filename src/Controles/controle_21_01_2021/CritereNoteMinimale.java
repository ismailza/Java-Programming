package Controles.controle_21_01_2021;

public class CritereNoteMinimale implements Predicat<Etudiant> {
    private final double NoteMinimale;

    public CritereNoteMinimale(double NoteMinimale) {
        this.NoteMinimale = NoteMinimale;
    }
    @Override
    public boolean test(Etudiant etudiant) {
        Note noteMoyenne = Note.noteMoyenne(etudiant.getNotes());
        return !noteMoyenne.isAbsent() && NoteMinimale <= noteMoyenne.getValeur();
    }
}
