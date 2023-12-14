package TP2.Exercice2;

public class TriSimple {
    private int size;
    private int curr_ind;
    private int increment;
    private int[] tab;

    TriSimple() {
        this.size = 20;
        this.increment = 10;
        this.curr_ind = -1;
        this.tab = new int[this.size];
    }
    TriSimple(int length, int increment) {
        this.size = length;
        this.increment = increment;
        this.curr_ind = -1;
        this.tab = new int[length];
    }

    public int length() {
        return curr_ind + 1;
    }

    public void inserer(int entier) {
        int i = 0;
        if (length() == size) {
            size += increment;
            int[] newTab = new int[size];
            while (i <= curr_ind && tab[i] < entier)
                    newTab[i] = tab[i++];
            newTab[i++] = entier;
            curr_ind++;
            for (; i <= curr_ind; i++)
                newTab[i] = tab[i-1];
            tab = newTab;
        }
        else {
            i = ++curr_ind;
            while (i > 0 && entier < tab[i-1])
                tab[i] = tab[--i];
            tab[i] = entier;
        }
    }

    void supprimer(int entier) {
        int i = 0;
        if (2 * increment <= size - length()) {
            size -= increment;
            int[] newTab = new int[size];
            while (i <= curr_ind) {
                if (tab[i] == entier) {
                    curr_ind--;
                    break;
                }
                newTab[i] = tab[i++];
            }
            for (; i <= curr_ind; newTab[i] = tab[++i]);
           tab = newTab;
        }
        else {
            for (i = 0; i <= curr_ind; i++) {
                if (tab[i] == entier) {
                    curr_ind--;
                    break;
                }
            }
            for (; i <= curr_ind; tab[i] = tab[++i]) ;
        }
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i <= curr_ind; i++)
            str.append(tab[i]).append(" ");
        return "TriSimple{" +
                "size=" + size +
                ", curr_ind=" + curr_ind +
                ", tab=[" + str + "]" +
                '}';
    }
}
