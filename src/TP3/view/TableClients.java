package TP3.view;

import TP3.model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;

public class TableClients extends JPanel {
    private Iterator<Client> clients;
    private JTable clientTable;
    public TableClients(Iterator<Client> clients) {
        this.clients = clients;
        this.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Liste des clients");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        String[] columnNames = {"CIN", "NOM", "Prénom", "Civilité"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        while (this.clients.hasNext()) {
            Client client = this.clients.next();
            Object[] rowData = {client.getCIN(), client.getNom(), client.getPrenom(), client.getCivilite()};
            model.addRow(rowData);
        }
        clientTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(clientTable);
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void setClients(Iterator<Client> clients) {
        this.clients = clients;
        updateTableData();
    }

    public void updateTableData() {
        DefaultTableModel model = (DefaultTableModel) clientTable.getModel();
        model.setRowCount(0);

        while (this.clients.hasNext()) {
            Client client = this.clients.next();
            Object[] rowData = {client.getCIN(), client.getNom(), client.getPrenom(), client.getCivilite()};
            model.addRow(rowData);
        }
    }
}
