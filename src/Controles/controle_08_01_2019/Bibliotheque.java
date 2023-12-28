package Controles.controle_08_01_2019;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private String nom;
    private int capacite;
    private List<Document> documents;

    public Bibliotheque(String nom, int capacite) {
        this.nom = nom;
        this.capacite = capacite;
        this.documents = new ArrayList<>();
    }

    public void findDocuments() {
        for (Document document : documents)
            System.out.println(document);
    }

    public void findDocumentByTitre(String titre) {
        for (Document document : documents)
            if (document.titre.equals(titre))
                System.out.println(document);
    }

    public void addDocument(Document document) {
        try {
            if (documents.size() == capacite)
                throw new PlusDePlaceException();
            documents.add(document);
        } catch (PlusDePlaceException e) {
            System.out.println(e.getMessage());
        }
    }

}
