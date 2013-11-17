/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import domain.Speelveld.VeldType;
import java.util.Objects;
/**
 *
 * @author AudioMatic
 */
public class Route {
    
    
       private List<Knooppunt>kortsteWeg = new ArrayList<>();
       
    public Route() {
        
       
        
    }

     public void appendKnooppunt(Knooppunt knooppunt){
        this.kortsteWeg.add(knooppunt);
        
    }
    
    public void prependKnooppunt(Knooppunt knooppunt){
        this.kortsteWeg.add(0, knooppunt);
        
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Route other = (Route) obj;
        if (!Objects.equals(this.kortsteWeg, other.kortsteWeg)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Route{" + "kortsteWeg=" + kortsteWeg + '}';
    }
    
    

    

            
       
    
}
