package TP4.partie4;

public class Simulation {
    static Jouet[] lesJouets;

    public static void main(String[] args) {
        lesJouets = new Jouet[10];
        for (int i = 0; i < 10; lesJouets[i] = new Jouet(i++));

        VerificateurJouet verificateurJouet1 = new VerificateurJouet("Ahmed", 2);
        VerificateurJouet verificateurJouet2 = new VerificateurJouet("Amine", 2);
        Verificateur verificateur1 = new Verificateur("Bachir", 1);

        verificateurJouet1.thread.start();
        verificateurJouet2.thread.start();
        verificateur1.thread.start();
    }
}
