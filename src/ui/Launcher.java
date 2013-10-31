/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Knooppunt;
import domain.Route;
import domain.Speelveld;
import domain.Speelveld.VeldType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AudioMatic
 */
public class Launcher {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gui gui = new Gui();
       
        // TODO code application logic here
       VeldType speelveld[][] = new VeldType[5][6];
       Speelveld eenspeelveld = new Speelveld(speelveld);
//        
        Route korsteWeg = eenspeelveld.geefRoute(new Knooppunt(0,0), new Knooppunt(5,3));
        
        
     //   gui.load();
        
    }

   

   
}
