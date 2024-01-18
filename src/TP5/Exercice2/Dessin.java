package TP5.Exercice2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dessin extends Canvas {
    private String shape;
    private Color color;
    private boolean fill;
    Point start, end;

    public Dessin() {
        this.shape = "Rectangle";
        this.color = Color.BLACK;
        this.fill = false;
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
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public void paint(Graphics g) {
        if (start == null || end == null)
            return;
        g.setColor(color);
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);
        switch (shape) {
            case "Rectangle" -> {
                if (fill)
                    g.fillRect(x, y, width, height);
                else
                    g.drawRect(x, y, width, height);
            }
            case "Ellipse" -> {
                if (fill)
                    g.fillOval(x, y, width, height);
                else
                    g.drawOval(x, y, width, height);
            }
            case "Ligne" -> {
                g.drawLine(start.x, start.y, end.x, end.y);
            }
        }
    }
}
