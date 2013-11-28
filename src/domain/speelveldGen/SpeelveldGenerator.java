/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.speelveldGen;

import domain.Speelveld;
import static java.lang.Math.random;

/**
 *
 * @author johan
 */
public class SpeelveldGenerator extends Speelveld {
    
    private int rij = 0;
    private int kol = 0;

    public SpeelveldGenerator(VeldType[][] speelveld , int rij , int kol) {
        super(speelveld);
        setRij(rij);
        setKol(kol);
        genSpeelveld();
        
        
    }

    private void setRij(int rij) throws IllegalArgumentException { 
        if(rij <= 0) throw new IllegalArgumentException("Rij mag niet onder 0 gaan");
        this.rij = rij;
        
    }

    private void setKol(int kol)throws IllegalArgumentException {
         if(rij <= 0) throw new IllegalArgumentException("Kolom mag niet onder 0 gaan");
         this.kol = kol;
    }
    

    private VeldType[][] genSpeelveld() {
        
        int max = 2;
        int min = 1;
        int range = (max - min) + 1;
        int type = 0;
        
        for(int i = 0; i < speelveld.length ; i ++){
             for(int j = 0 ; j< speelveld[i].length ; j++){
                 type = (int) (Math.random() * range) + min;
                 
                 if(type == 2){
                   speelveld[i][j] = VeldType.MUUR;
                 }else{
                      speelveld[i][j] = VeldType.LEEG;
                 }
                     
                 
             }
        
       return speelveld;
    }
        return speelveld;
    
    
    
    
    
}}
