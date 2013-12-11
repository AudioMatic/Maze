/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Objects;
/**
 *
 * @author AudioMatic
 */
public class Route implements Iterable<Knooppunt> {
    
    
       private List<Knooppunt>kortsteWeg = new ArrayList<>();
       
    public Route() {
        
       
        
    }
/**
 * 
 * @param knooppunt
 * Voegt een knooppunt toe achteraan de arraylist
 */
     public void appendKnooppunt(Knooppunt knooppunt){
        this.kortsteWeg.add(knooppunt);
        
    }
    /**
     * 
     * @param knooppunt 
     * voegt een knooppunt toe vooraan de arraylist
     */
    public void prependKnooppunt(Knooppunt knooppunt){
        this.kortsteWeg.add(0, knooppunt);
        
    }
    
   public int size(){
       return this.kortsteWeg.size();
   }
   
   public Knooppunt get(int i){
       return this.kortsteWeg.get(i);
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
/**
 * 
 * @return 
 */
    @Override
    public Iterator<Knooppunt> iterator() {
        return kortsteWeg.iterator();
    }
    
    

    

            
       
    
}
