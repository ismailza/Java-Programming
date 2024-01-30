package TP3.exception;

public class ClientAlreadyExistsException extends Exception {
    public ClientAlreadyExistsException(String cin) {
        super("Le CIN " + cin + " est déja exist!");
    }
}
