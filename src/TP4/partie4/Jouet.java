package TP4.partie4;

public class Jouet {
    private int numero;
    private boolean dejaVerifie;

    public Jouet(int numero) {
        this.numero = numero;
        this.dejaVerifie = false;
    }

    public void tuEsVerifiePar(VerificateurJouet verificateurJouet) {
        if (verificateurJouet instanceof Verificateur) {
            try {
                while (!dejaVerifie)
                    this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            verificateurJouet.verifieJouet(numero);
        }
        else if (!dejaVerifie) {
            verificateurJouet.verifieJouet(numero);
            this.dejaVerifie = true;
            this.notifyAll();
        }
    }
}
