package TP1.Exercice3;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice, search;
        String filename = "bibliotheque";
        BibliothequeIO bio = new BibliothequeIO(filename);
        Bibliotheque bibliotheque;
        File file = new File(filename);
        if (!file.exists() || (bibliotheque = bio.deserialize()) == null) {
            System.out.print("Entrer la capacité de la bibliothèque : ");
            bibliotheque = new Bibliotheque(sc.nextInt());
        }
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println(bibliotheque);
                    break;
                case 2:
                    System.out.println("Capacité : " + bibliotheque.capacite());
                    break;
                case 3:
                    System.out.println("Nombre de livre : " + bibliotheque.size());
                    break;
                case 4:
                    addBook(bibliotheque);
                    break;
                case 5:
                    do {
                        displaySearchMenu();
                        search = sc.nextInt();
                        sc.nextLine();
                        handleSearch(search, bibliotheque);
                    } while (search != 0);
                    break;
                case 6:
                    bio.serialize(bibliotheque);
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        } while (choice != 0);
        bio.serialize(bibliotheque);
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("******************************************************");
        System.out.println("0. Arrêter le programme.");
        System.out.println("1. Afficher tous les livres.");
        System.out.println("2. Consulter la capacité de la bibliothèque.");
        System.out.println("3. Consulter le nombre de livres existe dans la bibliothèque.");
        System.out.println("4. Ajouter un livre.");
        System.out.println("5. Chercher un livre.");
        System.out.println("6. Sauvegarder la bibliotheque");
        System.out.print("=> ");
    }

    private static void displaySearchMenu() {
        System.out.println("******************************************************");
        System.out.println("0. Menu principal.");
        System.out.println("1. Chercher par ISBN");
        System.out.println("2. Chercher par titre");
        System.out.println("3. Chercher par auteur");
        System.out.print("=> ");
    }

    private static void handleSearch(int choice, Bibliotheque bibliotheque) {
        switch (choice) {
            case 1:
                System.out.print("ISBN : ");
                System.out.println(bibliotheque.chercherParISBN(sc.nextLine()));
                break;
            case 2:
                System.out.print("Titre : ");
                System.out.println(bibliotheque.chercherParTitre(sc.nextLine()));
                break;
            case 3:
                System.out.print("Auteur : ");
                System.out.println(bibliotheque.chercherParAuteur(sc.nextLine()));
                break;
            default:
                System.out.println("Choix incorrect!");
        }
    }

    private static void addBook(Bibliotheque bibliotheque) {
        String ISBN, title;
        int n = 0;
        byte add;
        Vector<String> athors = new Vector<>();
        float price;
        System.out.print("ISBN : ");
        ISBN = sc.nextLine();
        System.out.print("Titre : ");
        title = sc.nextLine();
        System.out.println("Auteurs : ");
        do {
            System.out.print("Auteur " + (n + 1) + " : ");
            athors.add(sc.nextLine());
            System.out.print("Ajouter un autre auteur : (1/0) ");
            add = sc.nextByte();
            sc.nextLine();
        } while (add == 1);
        System.out.print("Prix : ");
        price = sc.nextFloat();
        if (!bibliotheque.ajouterLivre(new Livre(ISBN, title, athors, price)))
            System.out.println("Capacité insuffisante!!");
    }
}
