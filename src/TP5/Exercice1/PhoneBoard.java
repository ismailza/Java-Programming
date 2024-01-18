package TP5.Exercice1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class PhoneBoard extends Frame implements ActionListener, WindowListener {
    private TextField textField;
    private List<Button> numButtons;
    private Button bisBtn, resetBtn;
    private String latest;

    public PhoneBoard() {
        super("Untitled");
        latest = "";
        textField = new TextField();
        textField.setEnabled(false);
        numButtons = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Button button = new Button(Integer.toString(i));
            button.addActionListener(this);
            numButtons.add(button);
        }
        bisBtn = new Button("Bis");
        resetBtn = new Button("Reset");
        bisBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        Panel btnPanel = this.setupBtnPanel();
        this.add(BorderLayout.NORTH, textField);
        this.add(BorderLayout.CENTER, btnPanel);
        this.pack();
        this.setMinimumSize(new Dimension(100, 200));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addWindowListener(this);
    }

    private Panel setupBtnPanel() {
        Panel panel = new Panel(new GridLayout(4,3));
        for (int i = 1; i < 10; i++)
            panel.add(this.numButtons.get(i));
        panel.add(this.bisBtn);
        panel.add(this.numButtons.get(0));
        panel.add(this.resetBtn);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button btn = (Button) e.getSource();
        if (btn.equals(this.bisBtn))
            textField.setText(this.latest);
        else if (btn.equals(this.resetBtn)) {
            this.latest = this.textField.getText();
            textField.setText("");
        }
        else
            textField.setText(textField.getText() + btn.getLabel());
    }

    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new PhoneBoard();
    }
}
