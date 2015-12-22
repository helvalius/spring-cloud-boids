package io.github.helvalius.boids.boid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.*;

import io.github.helvalius.boids.data.Boid;

public class Screen extends JPanel {

    private final Flock flockManager;

    public Screen(int width, int height, Flock flockManager) {
        this.flockManager = flockManager;

        JFrame frame = new JFrame("Flock Simulation");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        this.setPreferredSize(new Dimension(width, height));
        frame.getContentPane().add(this);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

    private void draw(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1000, 1000);
        g2d.setColor(Color.blue);

        List<Boid> boids = flockManager.flock();
        for (Boid b : boids) {
            g2d.fillOval(pixelX(b.getPosition().x()) - 3, pixelY(b.getPosition().y()) - 3, 7, 7);
        }
    }

    private int pixelX(double x) {
        double screenX = x + (this.getWidth() / 2);
        return (int) Math.round(screenX);
    }

    private int pixelY(double y) {
        double screenY = (this.getHeight() / 2) - y;
        return (int) Math.round(screenY);
    }
}