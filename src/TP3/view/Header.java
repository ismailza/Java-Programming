package TP3.view;

import javax.swing.*;
import java.awt.*;

public interface Header {
    static JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(9, 141, 245));

        JPanel logoPanel = new JPanel();
        logoPanel.setOpaque(false);
        JLabel logo = new JLabel("IO Cars");
        logo.setFont(new Font("Pacifico", Font.BOLD, 30));
        logo.setForeground(Color.white);
        logoPanel.add(logo);

        header.add(logoPanel, BorderLayout.CENTER);

        return header;
    }
}
