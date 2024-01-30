package TP3.controller;

import TP3.critere.*;
import TP3.exception.MatriculeAlreadyExistException;
import TP3.model.Voiture;
import TP3.service.Agence;
import TP3.view.AddVoiture;
import TP3.view.TableVoitures;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class VoitureController {
    private Agence agence;
    private AddVoiture addVoiture;
    private TableVoitures tableVoitures;
    public VoitureController(Agence agence, AddVoiture addVoiture, TableVoitures tableVoitures) {
        this.agence = agence;
        this.addVoiture = addVoiture;
        this.tableVoitures = tableVoitures;
        this.addVoiture.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleVoitureSubmit();
            }
        });
        this.tableVoitures.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterCritere interCritere = new InterCritere();
                for (Map.Entry<String, JTextField> entry : tableVoitures.getFiltres().entrySet()) {
                    if (!entry.getValue().getText().isEmpty()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue().getText());
                        switch (entry.getKey()) {
                            case "Marque" -> interCritere.addCritere(new CritereMarque(entry.getValue().getText()));
                            case "Modèle" -> interCritere.addCritere(new CritereModel(entry.getValue().getText()));
                            case "Année" -> interCritere.addCritere(new CritereAnnee(Integer.parseInt(entry.getValue().getText())));
                            case "Prix" -> interCritere.addCritere(new CriterePrix(Float.parseFloat(entry.getValue().getText())));
                        }
                    }
                }
                tableVoitures.setVoitures(agence.selectionne(interCritere));
            }
        });
    }

    private void handleVoitureSubmit() {
        try {
            String matricule = addVoiture.getMatriculeField().getText();
            String marque = addVoiture.getBrandField().getText();
            String model = addVoiture.getModelField().getText();
            String year = addVoiture.getYearField().getText();
            String price = addVoiture.getPriceField().getText();
            if (checkInputs(matricule, marque, model, year, price)) {
                if (Float.parseFloat(price) < 50) throw new NumberFormatException();
                agence.ajouterVoiture(new Voiture(matricule, marque, model, Integer.parseInt(year), Float.parseFloat(price)));
                addVoiture.clearFormFields();
                tableVoitures.setVoitures(agence.lesVoitures());
                JOptionPane.showMessageDialog(null, "Voiture ajoutée avec succès!");
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs correctement!");
            }
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Vérifier les données que vous avez entrées!");
        } catch (MatriculeAlreadyExistException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'ajout de la voiture!");
        }
    }

    private boolean checkInputs(String... inputs) {
        for (String input : inputs)
            if (input.isEmpty())
                return false;
        return true;
    }

}
