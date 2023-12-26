package Controles.controle_30_01_2014;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Personnel personnel = new Personnel();
        personnel.ajouterEmploye(new Vendeur("VendNom1", "VendPrenom1", 22, new Date(),12000));
        personnel.ajouterEmploye(new Representant("RepNom1", "RepPrenom1", 18, new Date(), 10000));
        personnel.ajouterEmploye(new Technicien("TechNom1", "TechPrenom1", 23, new Date(), 100));
        personnel.ajouterEmploye(new Manutentionnaire("ManNom1", "ManPrenom1", 27, new Date(), 129));
        personnel.ajouterEmploye(new TechnicienD("TechDNom1", "TechDPrenom1", 28, new Date(), 111));
        personnel.ajouterEmploye(new ManutentionnaireD("ManDNom1", "ManDPrenom1", 30, new Date(), 65));
        personnel.ajouterEmploye(new ManutentionnaireD("ManDNom2", "ManDPrenom2", 30, new Date()));

        System.out.println("Le personnel de l'entreprise :");
        personnel.afficherSalaires();
        System.out.println("\nLe personnel trié par nom :");
        personnel.affichageTrieParNom();
        System.out.println("\nLe personnel trié par salaire :");
        personnel.affichageTrieParSalaire();
        System.out.println("\nSalaire moyen : " + personnel.salaireMoyen());

    }
}
