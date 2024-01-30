package TP3.view;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    private JButton homeBtn;
    private JButton dVoituresBtn, addVoitureBtn;
    private JButton dClientsBtn;
    private JButton dLocationsBtn;
    private JButton saveBtn;
    private JPanel mainContent;

    public Dashboard() {
        setTitle("IO Cars Rentals");
        setLayout(new BorderLayout());

        mainContent = new JPanel();

        add(BorderLayout.NORTH, Header.createHeaderPanel());
        add(BorderLayout.WEST, createMenuBar());
        add(BorderLayout.CENTER, mainContent);

        setSize(1100, 620);
        setMinimumSize(new Dimension(1000, 620));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getHomeBtn() {
        return homeBtn;
    }

    public JButton getdVoituresBtn() {
        return dVoituresBtn;
    }

    public JButton getAddVoitureBtn() {
        return addVoitureBtn;
    }

    public JButton getdClientsBtn() {
        return dClientsBtn;
    }

    public JButton getdLocationsBtn() {
        return dLocationsBtn;
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public void setMainContent(JPanel mainContent) {
        this.mainContent.removeAll();
        this.mainContent.add(mainContent);
        this.mainContent.revalidate();
        this.mainContent.repaint();
    }

    private JPanel createMenuBar() {
        JPanel menuBar = new JPanel();
        menuBar.setBackground(new Color(34, 40, 49));

        homeBtn = createMenuButton("Dashboard");

        JLabel voituresLabel = createMenuLabel("Voitures");
        dVoituresBtn = createMenuButton("Afficher voitures");
        addVoitureBtn = createMenuButton("Ajouter voiture");

        JLabel locationsLabel = createMenuLabel("Locations");
        dLocationsBtn = createMenuButton("Gérer locations");

        JLabel clientsLabel = createMenuLabel("Clients");
        dClientsBtn = createMenuButton("Liste des clients");

        saveBtn = createMenuButton("Sauvegarde");

        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
        menuBar.add(Box.createVerticalStrut(20));

        menuBar.add(homeBtn);
        menuBar.add(createSeparator());

        menuBar.add(voituresLabel);
        menuBar.add(dVoituresBtn);
        menuBar.add(addVoitureBtn);
        menuBar.add(createSeparator());

        menuBar.add(locationsLabel);
        menuBar.add(dLocationsBtn);
        menuBar.add(createSeparator());

        menuBar.add(clientsLabel);
        menuBar.add(dClientsBtn);
        menuBar.add(createSeparator());

        menuBar.add(saveBtn);

        menuBar.add(createSeparator());
        menuBar.add(Box.createVerticalStrut(20));
        return menuBar;
    }

    static JButton createMenuButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(160, 40));
        button.setBackground(new Color(34, 40, 49));
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        return button;
    }

    static JLabel createMenuLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    static JSeparator createSeparator() {
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(new Color(85, 98, 112));
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);
        return separator;
    }
}
