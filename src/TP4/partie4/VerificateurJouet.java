package TP4.partie4;

import java.util.Random;

import static java.lang.Thread.sleep;

public class VerificateurJouet implements Runnable {
    protected String name;
    protected int speed;
    public Thread thread;

    public VerificateurJouet(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.thread = new Thread(this);
        this.thread.setPriority(this.speed);
    }

    public int getSpeed() {
        return speed;
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
