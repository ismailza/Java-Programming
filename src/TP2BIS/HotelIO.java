package TP2BIS;

import java.io.*;

public class HotelIO {
    private String filename;
    HotelIO(String filename) {
        this.filename = filename;
    }

    public void serialize(Hotel hotel) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(hotel);
            oos.flush();
            oos.close();
            System.out.println("Hotel a été sauvegardé avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde de l'hotel : " + e.getMessage());
        }
    }

    public Hotel deserialize() {
        Hotel hotel = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            hotel = (Hotel) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors de la désérialisation de l'hotel : " + e.getMessage());
        }
        return hotel;
    }
}
