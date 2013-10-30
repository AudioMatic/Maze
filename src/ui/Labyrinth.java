/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Knooppunt;
import domain.Speelveld.VeldType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AudioMatic
 */
public class Labyrinth {

    
   
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VeldType speelveld[][] = new VeldType[5][6];
        
        List<Knooppunt> korsteWeg = geefRoute(speelveld, new Knooppunt(0,0), new Knooppunt(5,3));
    }
}
