/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import domain.Speelveld.VeldType;


/**
 *
 * @author AudioMatic
 */
public class Launcher {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CanvasJFrame map = new CanvasJFrame();
        
      VeldType speelveld[][] = new VeldType[5][6];
      
       SpeelveldUI eenspeelveld = new SpeelveldUI(speelveld);
       
//        Route korsteWeg = eenspeelveld.geefRoute(new Knooppunt(0,0), new Knooppunt(5,3));
        map.load(eenspeelveld);
        
     //   gui.load();
        
        
    }

   

   
}
