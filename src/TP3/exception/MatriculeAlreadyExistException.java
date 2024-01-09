package TP3.exception;

public class MatriculeAlreadyExistException extends Exception {
    public MatriculeAlreadyExistException(String maricule) {
        super("Le matricule " + maricule + " est déja existe!");
    }
}
