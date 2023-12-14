package TP1.Exercice3;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        String filename = "bibliotheque";
        Bibliotheque bibliotheque = deserialize(filename);
        do {
            displayMenu();
            System.out.print("=> ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println(bibliotheque);
                    break;
                case 2:
                    addBook(sc, bibliotheque);
                    break;
                case 3:
                    System.out.println("Capacité : " + bibliotheque.capacite());
                    break;
                case 4:
                    System.out.println("Nombre de livre : " + bibliotheque.size());
                    break;
                case 5:
                    System.out.print("Nom de l'auteur : ");
                    String athor = sc.nextLine();
                    searchBooks(bibliotheque, athor);
                    break;
                case 6:
                    serialize(filename, bibliotheque);
                    break;
                default:
                    System.out.println("Choix invalide!");
            }
        } while (choice != 0);
        serialize(filename, bibliotheque);
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("******************************************************");
        System.out.println("0. Arrêter le programme.");
        System.out.println("1. Afficher les livres de la bibliothèque.");
        System.out.println("2. Ajouter un livre.");
        System.out.println("3. Consulter la capacité de la bibliothèque.");
        System.out.println("4. Consulter le nombre de livres existe dans la bibliothèque.");
        System.out.println("5. Chercher les livres d'un auteur.");
        System.out.println("6. Sauvegarder la bibliotheque");
    }

    private static void addBook(Scanner sc, Bibliotheque bibliotheque) {
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

    public static void searchBooks(Bibliotheque bibliotheque, String athor) {
        System.out.println("Les livres écrits par " + athor + " :");
        System.out.println(bibliotheque.cherche(athor));
    }

    public static void serialize(String filename, Bibliotheque bibliotheque) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(bibliotheque);
            oos.flush();
            oos.close();
            System.out.println("Bibliothèque sérialisée avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sérialisation de la bibliothèque : " + e.getMessage());
        }
    }

    public static Bibliotheque deserialize(String filename) {
        Bibliotheque bibliotheque = null;
        Scanner sc = new Scanner(System.in);
        File file = new File(filename);
        if (!file.exists()) {
            System.out.print("Entrer la capacité de la bibliothèque : ");
            return new Bibliotheque(sc.nextInt());
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            bibliotheque = (Bibliotheque) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors de la désérialisation de la bibliothèque : " + e.getMessage());
        }
        return bibliotheque;
    }
}
