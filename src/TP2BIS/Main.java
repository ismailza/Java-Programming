package TP2BIS;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice, crud, sort;
        String filename = "chambres.dat";
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
                    do {
                        displayMenu1();
                        crud = sc.nextInt();
                        sc.nextLine();
                        switch (crud) {
                            case 0:
                                break;
                            case 1:
                                hotel.ajouterChambre();
                                break;
                            case 2:
                                if (hotel.modifierChambre(getNumFromKeyboard(sc, hotel)))
                                    System.out.println("La modification à été effectuée avec succès");
                                else
                                    System.out.println("La modification à été échoué! Numéro incorrect");
                                break;
                            case 3:
                                if (hotel.supprimerChambre(getNumFromKeyboard(sc, hotel)))
                                    System.out.println("La Suppression à été effectuée avec succès");
                                else
                                    System.out.println("La suppression à été échoué! Numéro incorrect");
                                break;
                            default:
                                System.out.println("Choix invalid!");
                        }
                    } while (crud != 0);
                    break;
                case 3:
                    System.out.print("Categorie : ");
                    hotel.afficherParCategorie(sc.nextInt());
                    break;
                case 4:
                    hotel.afficherParEtat('L');
                    break;
                case 5:
                    hotel.afficherParEtat('O');
                    break;
                case 6:
                    do {
                        displaySortMenu();
                        sort = sc.nextInt();
                        sc.nextInt();
                        switch (sc.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                hotel.trieParNumero();
                                System.out.println(hotel);
                                break;
                            case 2:
                                hotel.trieParCategorie();
                                System.out.println(hotel);
                                break;
                            case 3:
                                hotel.trieParCapacite();
                                System.out.println(hotel);
                                break;
                            case 4:
                                hotel.trieParPrix();
                                System.out.println(hotel);
                                break;
                            default:
                                System.out.println("Choix invalid!");
                        }
                    } while (sort != 0);
                    System.out.println(hotel);
                    break;
                case 7:
                    if (hotel.changerEtatChambre(getNumFromKeyboard(sc, hotel), 'O'))
                        System.out.println("La chambre à été réservé avec succès");
                    else
                        System.out.println("La réservation à été échoué! Numéro incorrect");
                    break;
                case 8:
                    if (hotel.changerEtatChambre(getNumFromKeyboard(sc, hotel), 'L'))
                        System.out.println("La chambre à été libiré avec succès");
                    else
                        System.out.println("Numéro incorrect!");
                    break;
                case 9:
                    hio.serialize(hotel);
                    break;
                default:
                    System.out.println("Choix invalid!");
                    break;
            }
        } while (choice != 0);
        sc.close();
        hio.serialize(hotel);
    }

    private static int getNumFromKeyboard(Scanner sc, Hotel hotel) {
        System.out.println(hotel);
        System.out.print("Numéro de chambre : ");
        return sc.nextInt();
    }

    private static void displayMenu() {
        System.out.println("********************************");
        System.out.println("0. Arreter le programme");
        System.out.println("1. Afficher toutes les chambres");
        System.out.println("2. Ajouter/ Modifier/ Supprimer");
        System.out.println("3. Afficher les chambre d'une categorie");
        System.out.println("4. Afficher les chambres libres");
        System.out.println("5. Afficher les chambre occupées");
        System.out.println("6. Trier les chambre");
        System.out.println("7. Réserver une chambre");
        System.out.println("8. Libirer une chambre");
        System.out.println("9. Sauvegarder l'hotel");
        System.out.print("=> ");
    }

    private static void displayMenu1() {
        System.out.println("********************************");
        System.out.println("0. Menu principal");
        System.out.println("1. Ajouter une chambre");
        System.out.println("2. Modifier une chambre");
        System.out.println("3. Supprimer une chambre");
        System.out.print("=> ");
    }

    private static void displaySortMenu() {
        System.out.println("********************************");
        System.out.println("0. Menu principal");
        System.out.println("1. Trie par numéro");
        System.out.println("2. Trie par catégorie");
        System.out.println("3. Trie par capacité");
        System.out.println("4. Trie par prix");
        System.out.print("=> ");
    }
}
