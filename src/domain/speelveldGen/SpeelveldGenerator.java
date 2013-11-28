/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.speelveldGen;

import domain.Speelveld;

/**
 *
 * @author johan
 */
public class SpeelveldGenerator extends Speelveld {
    
    private int rij = 0;
    private int kol = 0;

    public SpeelveldGenerator(VeldType[][] speelveld , int rij , int kol) {
        genSpeelveld(speelveld);
        setRij(rij);
        setKol(kol);
        
        
    }

    private void setRij(int rij) throws IllegalArgumentException { 
        if(rij <= 0) throw new IllegalArgumentException("Rij mag niet onder 0 gaan");
        
    }

    private void setKol(int kol)throws IllegalArgumentException {
         if(rij <= 0) throw new IllegalArgumentException("Kolom mag niet onder 0 gaan");
    }
    

    private VeldType genSpeelveld(VeldType[][] speelveld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
