package TP3.service;

import TP3.model.Client;

import java.io.Serializable;
import java.util.Comparator;

public class ClientComparator implements Comparator<Client>, Serializable {
    @Override
    public int compare(Client o1, Client o2) {
        return o1.getCIN().compareToIgnoreCase(o2.getCIN());
    }
}
