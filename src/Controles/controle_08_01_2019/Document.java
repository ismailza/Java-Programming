package Controles.controle_08_01_2019;

public abstract class Document {
    private static int sequenceur = 0;
    protected int num;
    protected String auteur;
    protected String titre;

    public Document(String auteur, String titre) {
        this.num = ++sequenceur;
        this.auteur = auteur;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Num : " + num + " - Auteur : " + auteur + " - Titre : " + titre;
    }
}
