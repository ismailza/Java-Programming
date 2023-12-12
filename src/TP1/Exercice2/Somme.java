package TP1.Exercice2;

public class Somme {
    public static void main(String[] args) {
        double result = 0;
        if (args.length == 0) {
            System.out.println("Pas d'arguments!");
            return;
        }
        for (String str : args) {
            try {
                result += Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Erreur lors de la conversion de l'argument \"" + str + "\"!!");
            }
        }
        System.out.println("Result : " + result);
    }
}
