package TP4.partie2;

import java.util.Random;

import static java.lang.Thread.sleep;

public class VerificateurJouet implements Runnable {
    private String name;
    public Thread thread;

    public VerificateurJouet(String name) {
        this.name = name;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        for (Jouet jouet : Simulation.lesJouets) {
            synchronized (jouet) {
                jouet.tuEsVerifiePar(this);
            }
        }
    }

    public void verifieJouet(int numJouet) {
        System.out.println(name + " commence la vérification du jouet n°" + numJouet);
        try {
            sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(name +" est terminée la vérification du jouet n°" + numJouet);
        }
    }
}
