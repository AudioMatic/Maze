/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AudioMatic
 */
public class Route {
    
    
       private List<Knooppunt>kortsteWeg = new ArrayList<>();
       
    public Route() {
        
       
        
    }

    
    
    public void addKnooppunt(Knooppunt knooppunt){
        
    }

    @Override
    public String toString() {
        return "Route{" + "kortsteWeg=" + kortsteWeg + '}';
    }
    
    

    

            
       
    
}
