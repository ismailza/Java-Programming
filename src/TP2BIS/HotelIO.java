package TP2BIS;

import java.io.*;

public class HotelIO {
    private String filename;
    HotelIO(String filename) {
        this.filename = filename;
    }

    public void saveHotel(Hotel hotel) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(hotel.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde!");
        }
    }

    public Hotel loadHotel() {
        Hotel hotel = new Hotel();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            String[] parts;
            if ((line = reader.readLine()) != null) {
                parts = line.split(":");
                if (parts.length == 2)
                    hotel.setNumSeq(Integer.parseInt(parts[1].trim()));
            }
            while ((line = reader.readLine()) != null) {
                parts = line.split(",");
                if (parts.length == 5) {
                    hotel.ajouterChambre(new Chambre(
                            Integer.parseInt(parts[0].split(":")[1].trim()),
                            Integer.parseInt(parts[1].split(":")[1].trim()),
                            Float.parseFloat(parts[2].split(":")[1].trim()),
                            Integer.parseInt(parts[3].split(":")[1].trim()),
                            parts[4].split(":")[1].trim().charAt(0)
                    ));
                } else
                    System.out.println("La ligne ne contient pas les informations attendues : " + line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier spécifié est introuvable : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur de conversion de données : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
        }
        return hotel;
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
