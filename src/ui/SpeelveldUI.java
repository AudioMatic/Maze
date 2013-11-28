/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import domain.Speelveld;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author johan
 */
public class SpeelveldUI extends Speelveld {

    public SpeelveldUI(VeldType[][] veldtypematrix ) {
        super(veldtypematrix);
    }
    
     public void drawSquares(Graphics g){
         Graphics2D mazeUI = (Graphics2D) g;
         mazeUI.setBackground(Color.WHITE);
         
         mazeUI.setColor(Color.GRAY);
         for(int i = 0; i < speelveld.length ; i ++){
             for(int j = 0 ; j< speelveld[i].length ; j++){
                 if(speelveld[i][j] == VeldType.MUUR){
                     mazeUI.fillRect(j * 20, i * 20 , 20, 20);
                 } else{
                     mazeUI.drawRect(j * 20 , i * 20 , 20, 20);
                 }
                     
                 
             }
         }
         
         
         
        
    }
    
}
