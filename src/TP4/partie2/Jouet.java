package TP4.partie2;

public class Jouet {
    private int numero;

    public Jouet(int numero) {
        this.numero = numero;
    }

    public void tuEsVerifiePar(VerificateurJouet verificateurJouet) {
        verificateurJouet.verifieJouet(numero);
    }
}
