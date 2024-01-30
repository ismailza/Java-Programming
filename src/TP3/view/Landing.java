package TP3.view;

import javax.swing.*;
import java.awt.*;

public class Landing extends JFrame {
    Login login;
    public Landing(Login login) {
        setTitle("IO Cars Rentals");
        setLayout(new BorderLayout());

        // Header Panel
        JPanel header = Header.createHeaderPanel();
        add(BorderLayout.NORTH, header);

        this.login = login;
        // Main Content Panel
        JPanel mainContent = createMainContentPanel();
        add(BorderLayout.CENTER, mainContent);

        // Footer Panel
        JPanel footer = Footer.createFooterPanel();
        add(BorderLayout.SOUTH, footer);

        // Background Color
        getContentPane().setBackground(new Color(240, 240, 240));

        setSize(1000, 600);
        setMinimumSize(new Dimension(1000, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createMainContentPanel() {
        JPanel mainContent = new JPanel(new BorderLayout());
        mainContent.setOpaque(false);

        JLabel welcomeLabel = new JLabel("Welcome to IO Cars Rentals");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        mainContent.add(welcomeLabel, BorderLayout.NORTH);
        mainContent.add(login, BorderLayout.CENTER);

        return mainContent;
    }
}
