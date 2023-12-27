package Controles.controle_21_01_2021;

public class ResultatModule {
    private final String NomModule;
    private final Note Note;
    public ResultatModule(String nomModule, Note note) {
        this.NomModule = nomModule;
        this.Note = note;
    }

    public Note getNote() {
        return Note;
    }

    @Override
    public String toString() {
        return NomModule + " : " + Note;
    }
}
