package TP3;

import TP3.critere.*;
import TP3.eumeration.Civilite;
import TP3.exception.ClientNotFoundException;
import TP3.exception.MatriculeNotFoundException;
import TP3.model.*;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AgenceIO agenceIO = new AgenceIO("CarRentalAgency");
        Agence agence;
        if (!agenceIO.isFileExist() || ((agence = agenceIO.deserialize()) == null))
            agence = new Agence();
        int choice;
        String cin, matricule;
        Client client;
        Voiture voiture;
        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    agence.afficherLesVoitures();
                    break;
                case 2:
                    handleCritereChoice(agence);
                    break;
                case 3:
                    handleAddVoiture(agence);
                    break;
                case 4:
                    agence.afficherLesVoitures();
                    System.out.print("CIN du client : ");
                    cin = sc.nextLine();
                    client = agence.findClientByCIN(cin);
                    if (client == null) {
                        System.out.println("Nouveau client");
                        client = handleAddClient(cin);
                        agence.addClient(client);
                    }
                    System.out.println(client);
                    do {
                        try {
                            System.out.print("Matricule : ");
                            matricule = sc.nextLine();
                            if ((voiture = agence.findVoitureByMatricule(matricule)) == null)
                                throw new MatriculeNotFoundException(matricule);
                            agence.loueVoiture(client, voiture);
                            break;
                        } catch (MatriculeNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    break;
                case 5:
                    try {
                        System.out.print("CIN : ");
                        cin = sc.nextLine();
                        if ((client = agence.findClientByCIN(cin)) == null)
                            throw new ClientNotFoundException(cin);
                        agence.rendVoiture(client);
                    } catch (ClientNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    for (Iterator<Voiture> iterator = agence.lesVoituresLoues(); iterator.hasNext();)
                        System.out.println(iterator.next());
                    break;
                default:
                    System.out.println("Choix invalide!");
            }

        } while (choice != 0);
        agenceIO.serialize(agence);
    }

    private static void displayMenu() {
        System.out.println("*******************************************************");
        System.out.println("0. Arreter le programme");
        System.out.println("1. Afficher les voitures de l'agence");
        System.out.println("2. Afficher selon un critere");
        System.out.println("3. Ajouter une voiture");
        System.out.println("4. Louer une voiture");
        System.out.println("5. Rendre une voiture");
        System.out.println("6. Afficher les voiture louées");
        System.out.print("=> ");
    }

    private static void displayCritereMenu() {
        System.out.println("*********************************");
        System.out.println("0. Arreter le programme");
        System.out.println("1. Critere de marque");
        System.out.println("2. Critere de prix");
        System.out.println("3. Critere d'année");
        System.out.println("4. Inter critere");
        System.out.print("=> ");
    }

    private static void handleCritereChoice(Agence agence) {
        int critere;
        do {
            displayCritereMenu();
            critere = sc.nextInt();
            sc.nextLine();
            switch (critere) {
                case 0:
                    break;
                case 1:
                    System.out.print("Marque : ");
                    agence.afficheSelection(new CritereMarque(sc.nextLine()));
                    break;
                case 2:
                    System.out.print("Prix : ");
                    agence.afficheSelection(new CriterePrix(sc.nextFloat()));
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Année : ");
                    agence.afficheSelection(new CritereAnnee(sc.nextInt()));
                    sc.nextLine();
                    break;
                case 4:
                    InterCritere interCritere = new InterCritere();
                    System.out.println("Ajouter vos criteres :");
                    do {
                        System.out.println("0. Terminer");
                        System.out.println("1. Critere de marque");
                        System.out.println("2. Critere de prix");
                        System.out.println("3. Critere d'année");
                        critere = sc.nextInt();
                        sc.nextLine();
                        switch (critere) {
                            case 0:
                                break;
                            case 1:
                                System.out.print("Marque : ");
                                interCritere.addCritere(new CritereMarque(sc.nextLine()));
                                break;
                            case 2:
                                System.out.print("Prix : ");
                                interCritere.addCritere(new CriterePrix(sc.nextFloat()));
                                sc.nextLine();
                                break;
                            case 3:
                                System.out.print("Année : ");
                                interCritere.addCritere(new CritereAnnee(sc.nextInt()));
                                sc.nextLine();
                                break;
                            default:
                                System.out.println("*** Choix invalide!");
                        }
                    } while (critere != 0);
                    System.out.println("*** Votre sélection ");
                    agence.afficheSelection(interCritere);
                    break;
                default:
                    System.out.println("*** Choix invalide!");
            }
        } while (critere != 0);
    }

    private static void handleAddVoiture(Agence agence) {
        System.out.print("Matricule : ");
        String matricule = sc.nextLine();
        System.out.print("Marque : ");
        String marque = sc.nextLine();
        System.out.print("Model : ");
        String model = sc.nextLine();
        System.out.print("Année : ");
        int annee = sc.nextInt();
        sc.nextLine();
        System.out.print("Prix location : ");
        float prix = sc.nextFloat();
        sc.nextLine();
        agence.ajouterVoiture(new Voiture(matricule, marque, model, annee, prix));
    }

    private static Client handleAddClient(String CIN) {
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        int civilite;
        do {
            System.out.print("Civilite : 0:M, 1:Mlle, 2:Mme : ");
            civilite = sc.nextInt();
            sc.nextLine();
        } while (civilite < 0 || 2 < civilite);
        return switch (civilite) {
            case 0 -> new Client(nom, prenom, CIN, Civilite.M);
            case 1 -> new Client(nom, prenom, CIN, Civilite.Mlle);
            case 2 -> new Client(nom, prenom, CIN, Civilite.Mme);
            default -> null;
        };
    }

    private static void setUpAgency(Agence agence) {
        agence.ajouterVoiture(new Voiture("123457", "Volkswagen", "Golf", 2019, 2500));
        agence.ajouterVoiture(new Voiture("123458", "Subaru", "Outback", 2021, 2700));
        agence.ajouterVoiture(new Voiture("123459", "Toyota", "Rav4", 2022, 3000));
        agence.ajouterVoiture(new Voiture("123465", "Honda", "Accord", 2019, 2700));
        agence.ajouterVoiture(new Voiture("123460", "Nissan", "Altima", 2020, 2600));
        agence.ajouterVoiture(new Voiture("123462", "Audi", "Q5", 2020, 3200));
        agence.ajouterVoiture(new Voiture("123456", "Mercedes-Benz", "C-Class", 2020, 2900));
        agence.ajouterVoiture(new Voiture("123463", "Ford", "Escape", 2023, 3100));
        agence.ajouterVoiture(new Voiture("123464", "Chevrolet", "Equinox", 2021, 2800));
        agence.ajouterVoiture(new Voiture("123466", "BMW", "3 Series", 2022, 3300));
        agence.ajouterVoiture(new Voiture("123467", "Hyundai", "Tucson", 2020, 2900));
        agence.ajouterVoiture(new Voiture("123461", "Jeep", "Wrangler", 2018, 2800));
        agence.ajouterVoiture(new Voiture("123468", "Kia", "Sportage", 2023, 2950));
        agence.ajouterVoiture(new Voiture("123469", "Lexus", "RX", 2021, 3400));
        agence.ajouterVoiture(new Voiture("123470", "Mazda", "CX-5", 2018, 2050));
        agence.ajouterVoiture(new Voiture("123471", "Volvo", "XC60", 2022, 300));
        agence.ajouterVoiture(new Voiture("123472", "Infiniti", "Q50", 2019, 2950));
        agence.ajouterVoiture(new Voiture("123473", "Porsche", "Macan", 2021, 3800));
        agence.ajouterVoiture(new Voiture("123474", "GMC", "Terrain", 2017, 2600));
        agence.ajouterVoiture(new Voiture("123481", "Renault", "Captur", 2009, 99));
        agence.ajouterVoiture(new Voiture("123476", "Lincoln", "Corsair", 2020, 3300));
        agence.ajouterVoiture(new Voiture("123475", "Buick", "Encore", 2023, 3000));
        agence.ajouterVoiture(new Voiture("123477", "Cadillac", "XT5", 2018, 3200));
        agence.ajouterVoiture(new Voiture("123478", "Mitsubishi", "Outlander", 2022, 2750));
        agence.ajouterVoiture(new Voiture("123479", "Chrysler", "Pacifica", 2019, 2900));
        agence.ajouterVoiture(new Voiture("123480", "Land Rover", "Discovery", 2021, 3600));
        agence.ajouterVoiture(new Voiture("123485", "Dacia", "Logan", 2016, 159));
        agence.ajouterVoiture(new Voiture("123482", "Renault", "Megane", 2009, 100));
        agence.ajouterVoiture(new Voiture("123483", "Renault", "Clio", 2016, 200));
        agence.ajouterVoiture(new Voiture("123484", "Renault", "Kadjar", 2017, 220));
    }

}
