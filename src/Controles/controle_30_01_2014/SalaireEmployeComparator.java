package Controles.controle_30_01_2014;

import java.util.Comparator;

public class SalaireEmployeComparator implements Comparator<Employe> {
    @Override
    public int compare(Employe employe1, Employe employe2) {
        double sal1 = employe1.calculerSalaire();
        double sal2 = employe2.calculerSalaire();
        return Double.compare(sal1, sal2);
    }
}
