package Controles.controle_30_01_2014;

import java.util.ArrayList;

public class Personnel {
    ArrayList<Employe> employes;

    public Personnel() {
        this.employes = new ArrayList<>();
    }

    public void ajouterEmploye(Employe employe) {
        this.employes.add(employe);
    }

    public void afficherSalaires() {
        for (Employe employe : employes)
            System.out.println(employe.getNom() + " : " + employe.calculerSalaire());
    }

    public double salaireMoyen () {
        double average = 0;
        for (Employe employe : employes)
            average += employe.calculerSalaire();
        return average / (double) employes.size();
    }

    public void affichageTrieParNom() {
        employes.sort(new NomEmployeComparator());
        this.afficherSalaires();
    }

    public void affichageTrieParSalaire() {
        employes.sort(new SalaireEmployeComparator());
        this.afficherSalaires();
    }
}
