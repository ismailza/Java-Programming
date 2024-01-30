package TP3.exception;

import TP3.model.Client;
import TP3.model.Voiture;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String cin) {
        super("Aucun client trouvé avec le CIN : " + cin);
    }

    public static class ClientAlreadyRentedVoitureException extends Exception {
        public ClientAlreadyRentedVoitureException(Client client, Voiture voiture) {
            super("Le client : " + client + " est déja loué la voiture : " + voiture);
        }
    }
}
