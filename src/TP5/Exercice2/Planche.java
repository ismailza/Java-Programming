package TP5.Exercice2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

public class Planche extends JFrame {
    private static final List<String> SHAPES = List.of("Rectangle", "Ellipse", "Ligne");
    private static final Map<String, Color> COLORS = Map.of("Noir", Color.BLACK, "Bleu", Color.BLUE, "Vert", Color.GREEN, "Rouge", Color.RED, "Jaune", Color.YELLOW, "Orange", Color.ORANGE);
    private Dessin dessin;

    public Planche() {
        super("Planche");
        setMenuBar(this.setupMenuBar());
        add(BorderLayout.SOUTH, setupToolsBar());
        this.dessin = new Dessin();
        add(BorderLayout.CENTER, this.dessin);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private MenuBar setupMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Fichier");
        MenuItem menuItem1 = new MenuItem("Fin");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem1);
        menuBar.add(menu);
        return menuBar;
    }

    private Panel setupToolsBar() {
        Panel panel = new Panel();

        Choice shapes = new Choice();
        SHAPES.forEach(shapes::add);
        shapes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dessin.setShape(shapes.getSelectedItem());
            }
        });
        panel.add(shapes);

        CheckboxGroup colors = new CheckboxGroup();
        Panel colorPanel = new Panel(new GridLayout(COLORS.size()/4 +1, 4));
        COLORS.forEach((key, value) -> {
            Checkbox checkbox = new Checkbox(key);
            checkbox.setCheckboxGroup(colors);
            checkbox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    dessin.setColor(COLORS.get(colors.getSelectedCheckbox().getLabel()));
                }
            });
            if (key.equals("Noir"))
                checkbox.setState(true);
            colorPanel.add(checkbox);
        });
        panel.add(colorPanel);

        Checkbox fill = new Checkbox("Rempli");
        fill.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dessin.setFill(fill.getState());
            }
        });
        panel.add(fill);

        return panel;
    }

    public static void main(String[] args) {
        new Planche();
    }
}
