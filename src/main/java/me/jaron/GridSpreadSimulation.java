package me.jaron;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GridSpreadSimulation extends JFrame {
    private static final int WINDOW_SIZE = 200;
    private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 20;

    private boolean[][] grid;
    private Random random;

    public GridSpreadSimulation() {
        setTitle("Grid Spread Simulation");
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        grid = new boolean[GRID_SIZE][GRID_SIZE];
        random = new Random();

        // Set initial states
        grid[0][0] = true;
        grid[9][9] = true;

        // Randomly set spread and lifetime chances for each cell
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col]) {
                    continue; // Skip cells already set to true
                }
                grid[row][col] = shouldSpread();
            }
        }
    }

    private boolean shouldSpread() {
        return random.nextDouble() < 0.5; // Adjust the spread chance here (e.g., 0.5 for 50% chance)
    }

    private int getLifetime(int row, int col) {
        // Adjust the maximum lifetime here (e.g., 10 for a maximum of 10 steps)
        return random.nextInt(11);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                int x = col * CELL_SIZE;
                int y = row * CELL_SIZE;

                if (grid[row][col]) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GridSpreadSimulation simulation = new GridSpreadSimulation();
            simulation.setVisible(true);
        });
    }
}
