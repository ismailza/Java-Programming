package TP3.test;

import TP3.Agence;
import TP3.critere.*;
import TP3.eumeration.Civilite;
import TP3.model.*;

import java.util.Iterator;

public class AgenceTest {
    private Agence agence;
    private Voiture voiture1;
    private Voiture voiture2;
    private Voiture voiture3;
    private Client client1;
    private Client client2;
    private Client client3;

    public void setUp() {
        this.agence = new Agence();
        this.voiture1 = new Voiture("123456", "Renault", "Megane", 2009, 100);
        this.voiture2 = new Voiture("123457", "Mercedes", "S580", 2022, 1500);
        this.voiture3 = new Voiture("123458", "Renault", "Clio", 2009, 100);
        this.agence.ajouterVoiture(voiture1);
        this.agence.ajouterVoiture(voiture2);
        this.agence.ajouterVoiture(voiture3);
        this.client1 = new Client("ZAHIR", "Ismail", "UA123456", Civilite.M);
        this.client2 = new Client("OUASLI", "Oumaima", "JA54321", Civilite.Mlle);
        this.client3 = new Client("OUTGOUGA", "JalalEddine", "KH98765", Civilite.M);
    }

    public void testSelectionne() {
        CriterePrix criterePrix = new CriterePrix(100);
        CritereMarque critereMarque = new CritereMarque("Renault");
        CritereAnnee critereAnnee = new CritereAnnee(2009);
        InterCritere interCritere = new InterCritere();
        interCritere.addCritere(criterePrix);
        interCritere.addCritere(critereMarque);
        interCritere.addCritere(critereAnnee);

        System.out.println("Critere prix <= 100 : ");
        agence.afficheSelection(criterePrix);
        System.out.println("Critere marque Renault : ");
        agence.afficheSelection(critereMarque);
        System.out.println("InterCriter : Critere marque Renault et Prix <= 100 et Annee 2009");
        agence.afficheSelection(interCritere);
    }

    public void testLoueVoiture() {
        agence.loueVoiture(client1, voiture2);
    }

    public void testEstLoueur() {
        if (agence.estLoueur(client1))
            System.out.println("Valide");
        else
            System.out.println("Non valide");
    }

    public void testEstLoue() {
        if (agence.estLoue(voiture2))
            System.out.println("Valide");
        else
            System.out.println("Non valide");
    }

    public void testRendVoiture() {
        agence.rendVoiture(client1);
        if (!agence.estLoue(voiture2))
            System.out.println("Valide");
        else
            System.out.println("Non valide");
    }

    public void testLesVoituresLoues() {
        Iterator<Voiture> iterator = agence.lesVoituresLoues();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    public static void main(String[] args) {
        AgenceTest agenceTest = new AgenceTest();
        agenceTest.setUp();

        System.out.println("TestLoueVoiture");
        agenceTest.testLoueVoiture();

        System.out.println("Test Est Louaur");
        agenceTest.testEstLoueur();

        System.out.println("Test est loue");
        agenceTest.testEstLoue();

        System.out.println("Test selection");
        agenceTest.testSelectionne();

        System.out.println("Les voiture loues");
        agenceTest.testLesVoituresLoues();

        System.out.println("Test Rend Voiture");
        agenceTest.testRendVoiture();

        System.out.println("Les voitures louées après retour");
        agenceTest.testLesVoituresLoues();
    }
}
