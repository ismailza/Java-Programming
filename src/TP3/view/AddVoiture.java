package TP3.view;

import javax.swing.*;
import java.awt.*;

public class AddVoiture extends JPanel {
    private JTextField matriculeField, brandField, modelField, yearField, priceField;
    JButton submitButton;
    public AddVoiture() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(240, 240, 240));
        JLabel titleLabel = new JLabel("Ajouter Voiture");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(240, 240, 240));

        JPanel formPanel = new JPanel(new GridLayout(7, 4, 15, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setBackground(new Color(240, 240, 240));

        matriculeField = new JTextField();
        brandField = new JTextField();
        modelField = new JTextField();
        yearField = new JTextField();
        priceField = new JTextField();

        setupFormField("Matricule:", matriculeField, formPanel);
        setupFormField("Marque:", brandField, formPanel);
        setupFormField("Modèle:", modelField, formPanel);
        setupFormField("Année:", yearField, formPanel);
        setupFormField("Prix location:", priceField, formPanel);

        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(60, 141, 239));
        submitButton.setForeground(Color.white);
        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.setPreferredSize(new Dimension(150, 40));
        submitButton.setFont(new Font("Arial", Font.BOLD, 18));

        formPanel.add(new JLabel());
        formPanel.add(submitButton);
        centerPanel.add(formPanel);

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }

    private void setupFormField(String label, JTextField field, JPanel formPanel) {
        formPanel.add(new JLabel());
        JLabel fieldLabel = new JLabel(label);
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        formPanel.add(fieldLabel);
        formPanel.add(field);
        formPanel.add(new JLabel());
    }

    public void clearFormFields() {
        this.matriculeField.setText("");
        this.brandField.setText("");
        this.modelField.setText("");
        this.yearField.setText("");
        this.priceField.setText("");
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JTextField getMatriculeField() {
        return matriculeField;
    }

    public JTextField getBrandField() {
        return brandField;
    }

    public JTextField getModelField() {
        return modelField;
    }

    public JTextField getYearField() {
        return yearField;
    }

    public JTextField getPriceField() {
        return priceField;
    }
}
