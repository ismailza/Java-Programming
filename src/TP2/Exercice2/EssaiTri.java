package TP2.Exercice2;

import java.util.Scanner;

public class EssaiTri {
    public static void main(String[] args) {
        TriSimple ts = new TriSimple();
        String choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("la lettre a suivie de données à insérer");
        System.out.println("la lettre s suivie de données à supprimer");
        System.out.println("la lettre q pour quitter");
        do {
            System.out.print("=> ");
            choice = sc.nextLine();

            try {
                if (choice.length() > 1) {
                    int n = Integer.parseInt(choice.substring(1));
                    switch (choice.charAt(0)) {
                        case 'a':
                            ts.inserer(n);
                            System.out.println(ts);
                            break;
                        case 's':
                            ts.supprimer(n);
                            System.out.println(ts);
                            break;
                        default:
                            throw new Exception();
                    }
                }
                else if (!choice.equals("q")) throw new Exception();
            } catch (NumberFormatException e) {
                System.out.println("Number format is incorrect!");
            } catch (Exception e) {
                System.out.println("Commande invalide!");
            }
        } while (!choice.equals("q"));
        sc.close();
    }
}
