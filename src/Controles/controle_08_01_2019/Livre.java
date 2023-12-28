package Controles.controle_08_01_2019;

public class Livre extends Document {
    private int nbPages;

    public Livre(String auteur, String titre, int nbPages) {
        super(auteur, titre);
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
        return super.toString() + " - Nombre de pages : " + nbPages;
    }
}
