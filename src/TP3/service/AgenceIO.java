package TP3;

import java.io.*;

public class AgenceIO {
    private String filename;
    public AgenceIO(String filename) {
        this.filename = filename;
    }

    public boolean isFileExist() {
        return new File(filename).exists();
    }
    public void serialize(Agence agence) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(agence);
            oos.close();
            System.out.println("La sauvegarde est effectué avec succès");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de l'agence dans le fichier! : " + e.getMessage());
        }
    }

    public Agence deserialize() {
        Agence agence = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            agence = (Agence) ois.readObject();
            ois.close();
        } catch (IOException |
                ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement de l'agence depuis le fichier! : " + e.getMessage());
        }
        return agence;
    }
}
