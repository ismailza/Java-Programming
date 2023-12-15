package TP1.Exercice3;

import java.io.*;
import java.util.Scanner;

public class BibliothequeIO {
    private String filename;

    BibliothequeIO(String filename) {
        this.filename = filename;
    }

    public void serialize(Bibliotheque bibliotheque) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(bibliotheque);
            oos.flush();
            oos.close();
            System.out.println("Bibliothèque a été sauvegardé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de la bibliothèque : " + e.getMessage());
        }
    }

    public Bibliotheque deserialize() {
        Bibliotheque bibliotheque = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            bibliotheque = (Bibliotheque) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors de la désérialisation de la bibliothèque : " + e.getMessage());
        }
        return bibliotheque;
    }
}
