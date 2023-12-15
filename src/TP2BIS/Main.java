package TP2BIS;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        String filename = "hotel";
        Scanner sc = new Scanner(System.in);
        HotelIO hio = new HotelIO(filename);
        Hotel hotel;
        File file = new File(filename);
        if (!file.exists() || (hotel = hio.deserialize()) == null) {
            hotel = new Hotel();
        }
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println(hotel);
                    break;
                case 2:
                    hotel.ajouterChambre();
                    break;
                case 3:
                    hio.serialize(hotel);
                    break;
                default:
                    System.out.println("Choix invalide!");
                    break;
            }
        } while (choice != 0);
        sc.close();
        hio.serialize(hotel);
    }

    private static void displayMenu() {
        System.out.println("********************************");
        System.out.println("0. Arreter le programme");
        System.out.println("1. Afficher toutes les chambres");
        System.out.println("2. Ajouter une chambre");
        System.out.println("3. Sauvegarder l'hotel");
        System.out.print("=> ");
    }
}
