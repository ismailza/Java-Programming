package TP4.partie1;

public class Simulation {
    public static void main(String[] args) {
        VerificateurJouet verificateurJouet1 = new VerificateurJouet("Ahmed");
        VerificateurJouet verificateurJouet2 = new VerificateurJouet("Amine");

        verificateurJouet1.thread.start();
        verificateurJouet2.thread.start();
    }
}
