/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

//imports
import java.awt.*;

import ui.Figures.Square;
import javax.swing.*;

/**
 *
 * @author johan
 */
public class Canvas extends JFrame {

    

    public Canvas() {
        super("Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Square squares = new Square();
        Component add = getContentPane().add(squares);
        for (int i = 0; i < 6; i++) {
            squares.addSquare(i * 10, i * 10, 10, 10);
        }
     

        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }
    
    public void load() {
        new Canvas();
    }
}
