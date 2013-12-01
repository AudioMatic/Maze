/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

//imports
import domain.Speelveld;
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

    CanvasPanel(Speelveld.VeldType speelveld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
     @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        speelveldUI.drawSpeelveld(g);
        
    }

    
}
