package TP4.partie2;

public class Simulation {
    static Jouet[] lesJouets;

    public static void main(String[] args) {
        lesJouets = new Jouet[10];
        for (int i = 0; i < 10; lesJouets[i] = new Jouet(i++));
        VerificateurJouet verificateurJouet1 = new VerificateurJouet("Ahmed");
        VerificateurJouet verificateurJouet2 = new VerificateurJouet("Amine");

        verificateurJouet1.thread.start();
        verificateurJouet2.thread.start();
    }
}
