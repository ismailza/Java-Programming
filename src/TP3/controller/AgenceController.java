package TP3.controller;

import TP3.exception.*;
import TP3.eumeration.Civilite;
import TP3.model.Client;
import TP3.service.Agence;
import TP3.service.AgenceIO;
import TP3.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgenceController {
    private Dashboard dashboard;
    private AgenceIO agenceIO;
    private Agence agence;
    private AddVoiture addVoiture;
    private VoitureController voitureController;
    private TableVoitures tableVoitures;
    private TableClients tableClients;
    private TableLocations tableLocations;

    public AgenceController() {
        this.agenceIO = new AgenceIO("CarRentalAgency");
        if (!agenceIO.isFileExist() || ((agence = agenceIO.deserialize()) == null))
            this.agence = new Agence();

        this.dashboard = new Dashboard();
        tableVoitures = new TableVoitures(agence.lesVoitures());
        addVoiture = new AddVoiture();
        tableClients = new TableClients(agence.lesClients());
        tableLocations = new TableLocations(agence.getLocations());
        voitureController = new VoitureController(agence, addVoiture, tableVoitures);
        dashboard.setMainContent(tableVoitures);
        dashboard.getHomeBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.setMainContent(tableLocations);
            }
        });
        dashboard.getdVoituresBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.setMainContent(tableVoitures);
            }
        });
        dashboard.getAddVoitureBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.setMainContent(addVoiture);
            }
        });
        dashboard.getdClientsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.setMainContent(tableClients);
            }
        });
        dashboard.getdLocationsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dashboard.setMainContent(tableLocations);
            }
        });
        dashboard.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                agenceIO.serialize(agence);
            }
        });
        dashboard.getSaveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenceIO.serialize(agence);
                JOptionPane.showMessageDialog(null, "Sauvegarde effectuée avec succes");
            }
        });
        tableVoitures.getRentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricule = tableVoitures.getSelectedVoitureMatricule();
                if (matricule != null) {
                    try {
                        Client client = getClientInformation();
                        if (client != null) {
                            rentVoitureToClient(client, matricule);
                        } else {
                            JOptionPane.showMessageDialog(null, "Operation annulée");
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }

            private Client getClientInformation() {
                String cin = getInput("Entrer CIN du client");
                if (cin == null) return null;

                Client client = agence.findClientByCIN(cin);
                if (client == null) {
                    JPanel panel = new JPanel(new GridLayout(0, 2));
                    JLabel cinLabel = new JLabel(cin);
                    JTextField nomField = new JTextField();
                    JTextField prenomField = new JTextField();
                    JComboBox<Civilite> civiliteBox = new JComboBox<>(Civilite.values());

                    panel.add(new JLabel("CIN:"));
                    panel.add(cinLabel);
                    panel.add(new JLabel("Nom:"));
                    panel.add(nomField);
                    panel.add(new JLabel("Prénom:"));
                    panel.add(prenomField);
                    panel.add(new JLabel("Civilité:"));
                    panel.add(civiliteBox);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Entrer les détails du client",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        String nom = nomField.getText();
                        String prenom = prenomField.getText();
                        Civilite civilite = (Civilite) civiliteBox.getSelectedItem();

                        if (!nom.isEmpty() && !prenom.isEmpty()) {
                            client = new Client(nom, prenom, cin, civilite);
                            agence.addClient(client);
                            tableClients.setClients(agence.lesClients());
                        } else {
                            JOptionPane.showMessageDialog(null, "Les champs Nom et Prénom ne doivent pas être vides.");
                            return null;
                        }
                    } else {
                        return null;
                    }
                }
                return client;
            }

            private String getInput(String message) {
                String input;
                do {
                    input = JOptionPane.showInputDialog(message);
                    if (input == null) return null;
                } while (input.isEmpty());
                return input;
            }

            private void rentVoitureToClient(Client client, String matricule) throws VoitureNotFoundException,
                    ClientNotFoundException.ClientAlreadyRentedVoitureException, VoitureAlreadyRentedException, ClientAlreadyRentedVoitureException {
                agence.loueVoiture(client, agence.findVoitureByMatricule(matricule));
                JOptionPane.showMessageDialog(null, "Location effectuée avec succès");
                tableLocations.setLocations(agence.getLocations());
            }
        });
        tableVoitures.getDisponibleCheckBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableVoitures.getDisponibleCheckBox().isSelected())
                    tableVoitures.setVoitures(agence.lesVoituresDisponibles());
                else
                    tableVoitures.setVoitures(agence.lesVoitures());
            }
        });
        tableLocations.getRenderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cin = tableLocations.getSelectedLocationCIN();
                if (cin != null) {
                    if (JOptionPane.showConfirmDialog(null, "Vous voulez vraiment rendre cette voiture?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        agence.rendVoiture(agence.findClientByCIN(cin));
                        tableLocations.setLocations(agence.getLocations());
                    }
                }
            }
        });
        tableLocations.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLocations.setLocations(agence.getLocations(tableLocations.getSearchedCIN()));
            }
        });
    }

}
