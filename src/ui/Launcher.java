/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Speelveld.VeldType;
import domain.Generators.SpeelveldGenerator;
import domain.Route;

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

        VeldType speelveld[][] = new VeldType[50][100];
        SpeelveldGenerator speelvgen = new SpeelveldGenerator(speelveld, 50, 100, 0.4);
        SpeelveldUI eenspeelveld = new SpeelveldUI(speelveld);
        
        Route route = eenspeelveld.geefRoute(eenspeelveld.getLeegKnooppunt(), eenspeelveld.getLeegKnooppunt());
        RouteUI eenRouteUI = new RouteUI(route);
//        Route korsteWeg = eenspeelveld.geefRoute(new Knooppunt(0,0), new Knooppunt(5,3));
        map.load(eenspeelveld);

    }

}
