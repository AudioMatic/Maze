/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

//imports
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;
import ui.Figures.Square;
import javax.swing.*;

/**
 *
 * @author johan
 */
public class Canvas extends JFrame {

    public void load() {
        new Canvas();
    }

    public Canvas() {
        super("Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Square squares = new Square();
        getContentPane().add(squares);
        for (int i = 0; i < 6; i++) {
            squares.addSquare(i * 10, i * 10, 10, 10);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }
}
