/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import domain.Speelveld;
import javax.swing.JFrame;

/**
 *
 * @author johan
 */
public class CanvasJFrame extends JFrame {

    
        public CanvasJFrame() {
            initUI();
        }

        private void initUI() {

            setSize(500, 500);
            setTitle("Maze");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        public void load(Speelveld.VeldType speelveld) {
         getContentPane().add(new CanvasPanel(speelveld));
         
         
            
            setVisible(true);
        }

    void load(SpeelveldUI eenspeelveld , RouteUI eenroute) {
            SpeelveldUI speelveld = eenspeelveld;
            RouteUI route = eenroute;
         getContentPane().add(new CanvasPanel(speelveld , route));
         
         
         
            
            setVisible(true);
        
    }
    
}
