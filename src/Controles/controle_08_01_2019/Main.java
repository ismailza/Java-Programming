package Controles.controle_08_01_2019;

public class Main {
    public static void main(String[] args) {
        Document livre1 = new Livre("Ismail", "Xi l3ba", 900);
        Document livre2 = new Livre("Mjid", "7aja makaynax", 950);
        Document roman1 = new Roman("Jalal", "Lbsala", 1200);
        Document roman2 = new Roman("Jalal", "Ya salam", 300);

        Bibliotheque bibliotheque = new Bibliotheque("Bibliotheque", 3);
        bibliotheque.addDocument(livre1);
        bibliotheque.addDocument(livre2);
        bibliotheque.addDocument(roman1);
        bibliotheque.addDocument(roman2);

        bibliotheque.findDocuments();
    }
}
