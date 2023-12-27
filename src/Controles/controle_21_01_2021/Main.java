package Controles.controle_21_01_2021;

public class Main {
    public static void main(String[] args) {
        Promotion promotion = setUpPromotion();
        promotion.printEtudiantResultats();
    }

    private static Promotion setUpPromotion() {
        Promotion promotion = new Promotion("Licence Informatique");

        Etudiant etudiant1 = new Etudiant("Ahmed", "Afifi");
        Etudiant etudiant2 = new Etudiant("Fatima", "Toto");

        etudiant1.addResultats("Langage C", new Note());
        etudiant1.addResultats("Structures de données C", new Note(15));

        etudiant2.addResultats("Langage C", new Note(13));
        etudiant2.addResultats("Structures de données C", new Note(11));

        promotion.addEtudiant(etudiant1);
        promotion.addEtudiant(etudiant2);

        return promotion;
    }
}
