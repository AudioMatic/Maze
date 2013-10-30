/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import ui.Labyrinth;

/**
 *
 * @author AudioMatic
 */
public class Speelveld {

   
    
    
    public enum VeldType {
        LEEG,
        MUUR,
        
    }
    
   
    
    private VeldType speelveld[][];

    public Speelveld(VeldType[][] speelveld) {
        setSpeelveld(speelveld);
    }
    
    
     private void setSpeelveld(VeldType[][] speelveld) {
        this.speelveld = speelveld;
    }
    
    
    
     public Route geefRoute( Knooppunt start, Knooppunt stop){
         return null;
        
    }
}
