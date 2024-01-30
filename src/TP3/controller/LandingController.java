package TP3.controller;

import TP3.view.Landing;
import TP3.view.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingController {
    private Landing landing;
    private Login login;

    public LandingController() {
        this.login = new Login();
        this.landing = new Landing(login);
        login.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getUsernameField().getText();
                char[] password = login.getPasswordField().getPassword();
                if (validateCredentials(username, password)) {
                    landing.dispose();
                    new AgenceController();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                    login.getPasswordField().setText("");
                }
            }
        });
    }

    private boolean validateCredentials(String username, char[] password) {
        return username.equals("ismail") || username.equals("oumaima") && new String(password).equals("1234");
    }
}
