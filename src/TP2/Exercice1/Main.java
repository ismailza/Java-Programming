package TP2.Exercice1;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length < 2) throw new Exception();
            for (int i = 0; i < args.length; i+=2) {
                try {
                    double d = Double.parseDouble(args[i]);
                    int n = Integer.parseInt(args[i+1]);
                    if (n < 0) throw new NumberFormatException();
                    System.out.print(tronque(d, n) + " \t");
                } catch (NumberFormatException e) {
                    System.out.println("Les arguments doivent être un nombre double suivi d'un entier positif ou nul.");
                }
            }
        } catch (Exception e) {
            System.out.println("Nombre d'arguments insuffisant! Il faut au moins 2 arguments et un nombre pair.");
        }
    }

    public static String tronque(double x, int nbDecimals) {
        StringTokenizer st = new StringTokenizer(Double.toString(x), ".");
        StringBuilder str1 = new StringBuilder(st.nextToken());
        if (nbDecimals == 0)
            return str1.toString();
        if (st.hasMoreTokens()) {
            str1.append(".");
            String str2 = st.nextToken();
            for (int i = 0; i < nbDecimals && i < str2.length(); i++)
                str1.append(str2.charAt(i));
        }
        return str1.toString();
    }
}
