package me.jaron;

import me.jaron.enitiys.Squares;
import me.jaron.jframe.Board;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Squares squares = new Squares();
        System.out.println("Starting...");
        Board board = new Board();  // Create an instance of the Board class
        board.setVisible(true);  // Make the JFrame visible

        double age = 1.2;
        double increment = 0.1;

        while (true) {
            age = age + increment;
            squares.setAge(age);
            System.out.println(age);

            // Generate random values for x and y within the grid size
            int x = new Random().nextInt(board.getGrid().length);
            int y = new Random().nextInt(board.getGrid()[0].length);

            if (squares.getSpreadChance() == Math.random()) {
                board.setActive(x, y);  // Set the specified square to true on the board
                squares.setOn(true);
                squares.changeColor(x,y, Color.GREEN);
                System.out.println("Setting: " + x + ", " + y +" active-----------------------------------");
            } else {
                board.setInactive(x, y);  // Set the specified square to false on the board
                squares.setOn(false);
                squares.changeColor(x,y, Color.BLUE);
                System.out.println("Setting: " + x + ", " + y +" d");
            }

            try {
                Thread.sleep(100); // Add a delay of 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
