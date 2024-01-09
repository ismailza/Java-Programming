package TP4.partie3;

public class Jouet {
    private int numero;
    private boolean dejaVerifie;

    public Jouet(int numero) {
        this.numero = numero;
        this.dejaVerifie = false;
    }

    public void tuEsVerifiePar(VerificateurJouet verificateurJouet) {
        if (!dejaVerifie) {
            verificateurJouet.verifieJouet(numero);
            this.dejaVerifie = true;
        }
    }
}
