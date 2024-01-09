package TP3.exception;

public class MatriculeNotFoundException extends Exception {
    public MatriculeNotFoundException(String matricule) {
        super("Le matricule " + matricule + " n'a pas été trouvé !");
    }
}
