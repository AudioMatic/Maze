/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Knooppunt;
import domain.Route;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author johan
 */
public class RouteUI {

    private Route r;

    RouteUI(Route r) {
        setR(r);
    }

    public void setR(Route r)throws IllegalArgumentException {
        if(r == null) throw new IllegalArgumentException("Er is geen route");
        this.r = r;
    }
    
    
    
    
    
    
   /**
    * Tekent de route in de JPanel
    * 
    */
    public void drawRoute(Graphics g) {
        Graphics2D routeUI = (Graphics2D) g;
        //routeUI.setBackground(Color.WHITE);

        boolean first = true;
        int counter =  0;
        int test = r.size()-1;
        for (Knooppunt eenKnooppunt : this.r) {
            if (first == true) {
                routeUI.setColor(Color.GREEN);
                routeUI.fillRect(eenKnooppunt.kol * 20, eenKnooppunt.rij * 20, 20, 20);
                first = false;
                counter++;
            } else if (counter == test) { // last element
                routeUI.setColor(Color.RED);
                routeUI.fillRect(eenKnooppunt.kol * 20, eenKnooppunt.rij * 20, 20, 20);
            } else {
                routeUI.setColor(Color.BLUE);
                routeUI.fillRect(eenKnooppunt.kol * 20, eenKnooppunt.rij * 20, 20, 20);
                counter++;
            }

        }
        
//        while(this.r.iterator().hasNext()){
//            Knooppunt eenKnooppunt = r.
//             routeUI.setColor(Color.BLUE);
//           routeUI.fillRect(eenKnooppunt.kol * 20, eenKnooppunt.rij * 20, 20, 20);
//        }


    }
}
