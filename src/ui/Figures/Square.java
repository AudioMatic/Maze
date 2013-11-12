/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Figures;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author johan
 */
public class Square extends JFrame {
    private static final int pwidth = 100;
    private static final int pheight = pwidth;
    private List<Rectangle> squares = new ArrayList<>();

    public void addSquare(int x , int y , int w , int h){
        Rectangle rect = new Rectangle(x, y, w, h);
        squares.add(rect);
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(pwidth , pheight);
    }

   
        protected void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g ;
        for(Rectangle rect : squares){
            g2.draw(rect);
        }
    }
    
    
    
}
