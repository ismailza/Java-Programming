package TP3.exception;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String cin) {
        super("Aucun client trouvé avec le CIN : " + cin);
    }
}
