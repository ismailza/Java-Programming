package TP3.service;

import TP3.critere.Critere;
import TP3.exception.*;
import TP3.model.*;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

public class Agence implements Serializable {
    private List<Voiture> voitures;
    private List<Client> clients;
    private Map<Client, Voiture> locations;

    public Agence() {
        this.voitures = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.locations = new TreeMap<>(new ClientComparator());
    }

    public void ajouterVoiture(Voiture voiture) throws MatriculeAlreadyExistException {
        for (Voiture v : voitures)
            if (v.getMatricule().equals(voiture.getMatricule()))
                throw new MatriculeAlreadyExistException(voiture.getMatricule());
        this.voitures.add(voiture);
    }

    public Voiture findVoitureByMatricule(String matricule) {
        for (Voiture voiture : voitures)
            if (voiture.getMatricule().equals(matricule))
                return voiture;
        return null;
    }
    public Iterator<Voiture> selectionne(Critere critere) {
        List<Voiture> voituresCritere = new ArrayList<>();
        for (Voiture v : voitures)
            if (critere.estSatisfaitPar(v))
                voituresCritere.add(v);
        return voituresCritere.listIterator();
    }

    public void afficheSelection(Critere critere) {
        Iterator<Voiture> iterator = this.selectionne(critere);
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client findClientByCIN(String CIN) {
        for (Client client : clients)
            if (client.getCIN().equals(CIN))
                return client;
        return null;
    }

    public void loueVoiture(Client client, Voiture voiture) throws VoitureAlreadyRentedException, VoitureNotFoundException, ClientAlreadyRentedVoitureException {
        if (!this.voitures.contains(voiture))
            throw new VoitureNotFoundException(voiture);
        if (estLoueur(client))
            throw new ClientAlreadyRentedVoitureException(client, this.locations.get(client));
        if (estLoue(voiture))
            throw new VoitureAlreadyRentedException(voiture);
        locations.put(client, voiture);
    }

    public boolean estLoueur(Client client) {
        return locations.containsKey(client);
    }

    public boolean estLoue(Voiture voiture) {
        return locations.containsValue(voiture);
    }

    public void rendVoiture(Client client) {
        locations.remove(client);
    }

    public Iterator<Voiture> lesVoituresLoues() {
        return locations.values().iterator();
    }

    public void afficherLesVoitures() {
        for (Voiture voiture : voitures)
            System.out.println(voiture);
    }

    public Iterator<Voiture> lesVoitures() {
        return voitures.iterator();
    }

    public Iterator<Client> lesClients() {
        return clients.iterator();
    }

    public Iterator<Entry<Client, Voiture>> getLocations() {
        return this.locations.entrySet().iterator();
    }

    public Iterator<Entry<Client, Voiture>> getLocations(String cin) {
        ArrayList<Entry<Client, Voiture>> filteredLocations = new ArrayList<>();
        for (Entry<Client, Voiture> entry : locations.entrySet())
            if (entry.getKey().getCIN().toUpperCase().contains(cin.toUpperCase()))
                filteredLocations.add(entry);
        return filteredLocations.iterator();
    }

    public Iterator<Voiture> lesVoituresDisponibles() {
        List<Voiture> voituresDisponibles = new ArrayList<>();
        for (Voiture voiture : voitures)
            if (!estLoue(voiture))
                voituresDisponibles.add(voiture);
        return voituresDisponibles.iterator();
    }
}
