package TP5.Exercice2;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

public class Planche1 extends Canvas {
    private static final java.util.List<String> SHAPES = List.of("Rectangle", "Ellipse", "Ligne");
    private static final Map<String, Color> COLORS = Map.of("Noir", Color.BLACK, "Bleu", Color.BLUE, "Vert", Color.GREEN, "Rouge", Color.RED, "Jaune", Color.YELLOW, "Orange", Color.ORANGE);
    private Choice shapes;
    private CheckboxGroup colors;
    private Checkbox fill;
    Point start, end;

    public Planche1() {
        Frame frame = new Frame("Planche");
        frame.setMenuBar(this.setupMenuBar());
        frame.add(BorderLayout.SOUTH, setupToolsBar());
        frame.add(BorderLayout.CENTER, this);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                start = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                end = e.getPoint();
                repaint();
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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

        shapes = new Choice();
        SHAPES.forEach(shapes::add);
        panel.add(shapes);

        colors = new CheckboxGroup();
        Panel colorPanel = new Panel(new GridLayout(COLORS.size()/4 +1, 4));
        COLORS.forEach((key, value) -> {
            Checkbox checkbox = new Checkbox(key);
            checkbox.setCheckboxGroup(colors);
            if (key.equals("Noir"))
                checkbox.setState(true);
            colorPanel.add(checkbox);
        });
        panel.add(colorPanel);

        fill = new Checkbox("Rempli");
        panel.add(fill);

        return panel;
    }

    @Override
    public void paint(Graphics g) {
        if (start == null || end == null)
            return;
        g.setColor(COLORS.get(colors.getSelectedCheckbox().getLabel()));
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);
        switch (shapes.getSelectedItem()) {
            case "Rectangle" -> {
                if (fill.getState())
                    g.fillRect(x, y, width, height);
                else
                    g.drawRect(x, y, width, height);
            }
            case "Ellipse" -> {
                if (fill.getState())
                    g.fillOval(x, y, width, height);
                else
                    g.drawOval(x, y, width, height);
            }
            case "Ligne" -> {
                g.drawLine(start.x, start.y, end.x, end.y);
            }
        }
    }

    public static void main(String[] args) {
        new Planche1();
    }
}
