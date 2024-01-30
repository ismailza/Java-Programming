package TP3.view;

import TP3.model.Voiture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TableVoitures extends JPanel {
    private Iterator<Voiture> voitures;
    private Map<String, JTextField> filtres;
    private JButton searchButton, rentButton;
    private JTable voitureTable;
    JCheckBox disponibleCheckBox;

    public TableVoitures(Iterator<Voiture> voitures) {
        this.setLayout(new BorderLayout());

        this.voitures = voitures;
        this.filtres = new HashMap<>();

        JLabel titleLabel = new JLabel("Liste des voitures");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        String[] columnNames = {"Matricule", "Marque", "Modèle", "Année", "Prix location"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while (this.voitures.hasNext()) {
            Voiture voiture = voitures.next();
            Object[] rowData = {voiture.getMatricule(), voiture.getMarque(), voiture.getModel(), voiture.getAnnee(), voiture.getPrixLocation()};
            model.addRow(rowData);
        }
        voitureTable = new JTable(model);
        voitureTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        voitureTable.setFillsViewportHeight(true);
        voitureTable.setDefaultEditor(Object.class, null);
        voitureTable.getColumnModel().setColumnSelectionAllowed(false);
        voitureTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(voitureTable);

        rentButton = new JButton("Louer voiture");
        JPanel main = new JPanel(new BorderLayout());
        main.add(BorderLayout.CENTER, scrollPane);
        main.add(BorderLayout.SOUTH, rentButton);

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(setupFilteresBar(), BorderLayout.CENTER);
        this.add(main, BorderLayout.SOUTH);
    }

    public void updateTableData() {
        DefaultTableModel model = (DefaultTableModel) voitureTable.getModel();
        model.setRowCount(0);

        while (voitures.hasNext()) {
            Voiture voiture = voitures.next();
            Object[] rowData = {voiture.getMatricule(), voiture.getMarque(), voiture.getModel(), voiture.getAnnee(), voiture.getPrixLocation()};
            model.addRow(rowData);
        }
    }

    public void setVoitures(Iterator<Voiture> voitures) {
        this.voitures = voitures;
        this.updateTableData();
    }

    public Map<String, JTextField> getFiltres() {
        return filtres;
    }

    public String getSelectedVoitureMatricule() {
        int selectedRow = voitureTable.getSelectedRow();
        if (selectedRow == -1)
            return null;
        DefaultTableModel model = (DefaultTableModel) voitureTable.getModel();
        return (String) model.getValueAt(selectedRow, 0);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getRentButton() {
        return rentButton;
    }

    public JCheckBox getDisponibleCheckBox() {
        return disponibleCheckBox;
    }

    private JPanel setupFilteresBar() {
        JPanel filtresBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        disponibleCheckBox = new JCheckBox("Disponible");
        filtresBar.add(disponibleCheckBox);

        this.filtres.put("Marque", new JTextField(10));
        this.filtres.put("Modèle", new JTextField(10));
        this.filtres.put("Année", new JTextField(10));
        this.filtres.put("Prix", new JTextField(10));

        filtresBar.add(new JLabel("Marque"));
        filtresBar.add(this.filtres.get("Marque"));
        filtresBar.add(new JLabel("Modèle"));
        filtresBar.add(this.filtres.get("Modèle"));
        filtresBar.add(new JLabel("Année"));
        filtresBar.add(this.filtres.get("Année"));
        filtresBar.add(new JLabel("Prix"));
        filtresBar.add(this.filtres.get("Prix"));

        searchButton = new JButton("Chercher");
        filtresBar.add(searchButton);

        return filtresBar;
    }
}
