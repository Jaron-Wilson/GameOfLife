package me.jaron;

import me.jaron.enitiys.Squares;
import me.jaron.jframe.Board;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Squares squares = new Squares();
        System.out.println("Starting...");
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();  // Create an instance of the Board class
            board.setVisible(true);  // Make the JFrame visible
        });

        BigDecimal age = new BigDecimal("1.2");
        BigDecimal increment = new BigDecimal("0.1");

        while (true) {
            System.out.println(age);
            age = age.add(increment);
            System.out.println(age);

            try {
                Thread.sleep(100); // Add a delay of 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}