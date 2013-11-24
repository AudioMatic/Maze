/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

//imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import ui.Figures.Square;
import javax.swing.*;

/**
 *
 * @author johan
 */
public class CanvasPanel extends JPanel {
    private SpeelveldUI speelveldUI;
    public CanvasPanel(SpeelveldUI speelveldui) {
        this.speelveldUI = speelveldui;
        

    }
    
   
    
     @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        speelveldUI.drawSquares(g);
        
    }

    
}
