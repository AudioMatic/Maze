/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

//imports
import domain.Speelveld;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author johan
 */
public class CanvasPanel extends JPanel {
    private SpeelveldUI speelveldUI;
    private RouteUI routeUI;
    public CanvasPanel(SpeelveldUI speelveldui , RouteUI routeUI) {
        this.speelveldUI = speelveldui;
        this.routeUI = routeUI;
        

    }

    CanvasPanel(Speelveld.VeldType speelveld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
     @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        speelveldUI.drawSpeelveld(g);
        if(routeUI.getR() != null){
           routeUI.drawRoute(g); 
        }
        
        
    }

    
}
