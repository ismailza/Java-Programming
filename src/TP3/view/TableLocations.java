package TP3.view;

import TP3.model.Client;
import TP3.model.Voiture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;
import java.util.Map.Entry;

public class TableLocations extends JPanel {
    private Iterator<Entry<Client, Voiture>> locations;
    private JTable locationsTable;
    private JTextField cinField;
    private JButton searchButton, renderButton;

    public TableLocations(Iterator<Entry<Client, Voiture>> locations) {
        this.locations = locations;
        this.setLayout(new BorderLayout());


        JLabel titleLabel = new JLabel("Liste des locations");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        String[] columnNames = {"CIN", "Nom complet", "Matricule", "Marque", "Modèle", "Année", "Prix location"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while (this.locations.hasNext()) {
            Entry<Client, Voiture> location = locations.next();
            Object[] rowData = {location.getKey().getCIN(), location.getKey().getCivilite() + ". " + location.getKey().getNom() + " " + location.getKey().getPrenom() , location.getValue().getMatricule(), location.getValue().getMarque(), location.getValue().getModel(), location.getValue().getAnnee(), location.getValue().getPrixLocation()};
            model.addRow(rowData);
        }
        locationsTable = new JTable(model);
        locationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        locationsTable.setFillsViewportHeight(true);
        locationsTable.setDefaultEditor(Object.class, null);
        locationsTable.getColumnModel().setColumnSelectionAllowed(false);
        locationsTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(locationsTable);

        renderButton = new JButton("Rendre voiture");
        JPanel main = new JPanel(new BorderLayout());
        main.add(BorderLayout.CENTER, scrollPane);
        main.add(BorderLayout.SOUTH, renderButton);

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(setupFilteresBar(), BorderLayout.CENTER);
        this.add(main, BorderLayout.SOUTH);
    }

    private JPanel setupFilteresBar() {
        JPanel filtresBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 200, 5));

        JPanel field = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        field.add(BorderLayout.WEST, new JLabel("CIN"));
        cinField = new JTextField(10);
        field.add(BorderLayout.EAST, cinField);
        filtresBar.add(field);

        searchButton = new JButton("Chercher");
        filtresBar.add(searchButton);

        return filtresBar;
    }

    public void updateTableData() {
        DefaultTableModel model = (DefaultTableModel) locationsTable.getModel();
        model.setRowCount(0);

        while (this.locations.hasNext()) {
            Entry<Client, Voiture> location = locations.next();
            Object[] rowData = {location.getKey().getCIN(), location.getKey().getCivilite() + ". " + location.getKey().getNom() + " " + location.getKey().getPrenom() , location.getValue().getMatricule(), location.getValue().getMarque(), location.getValue().getModel(), location.getValue().getAnnee(), location.getValue().getPrixLocation()};
            model.addRow(rowData);
        }
    }

    public void setLocations(Iterator<Entry<Client, Voiture>> locations) {
        this.locations = locations;
        this.updateTableData();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getRenderButton() {
        return renderButton;
    }

    public String getSelectedLocationCIN() {
        int selectedRow = locationsTable.getSelectedRow();
        if (selectedRow == -1)
            return null;
        DefaultTableModel model = (DefaultTableModel) locationsTable.getModel();
        return (String) model.getValueAt(selectedRow, 0);
    }

    public String getSearchedCIN() {
        return cinField.getText();
    }
}
