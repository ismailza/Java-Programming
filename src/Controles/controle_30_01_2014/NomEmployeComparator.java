package Controles.controle_30_01_2014;

import java.util.Comparator;

public class NomEmployeComparator implements Comparator<Employe> {
    @Override
    public int compare(Employe employe1, Employe employe2) {
        return employe1.nom().compareTo(employe2.nom());
    }
}
