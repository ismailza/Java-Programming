package TP3.view;

import javax.swing.*;
import java.awt.*;

public interface Footer {
    static JPanel createFooterPanel() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(9, 141, 245));

        JLabel copyrightLabel = new JLabel("© 2024 IO Cars Rentals. All rights reserved.");
        copyrightLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        copyrightLabel.setForeground(Color.white);
        copyrightLabel.setHorizontalAlignment(JLabel.CENTER);

        footer.add(copyrightLabel, BorderLayout.CENTER);

        return footer;
    }
}
