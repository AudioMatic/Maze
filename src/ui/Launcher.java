/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Speelveld.VeldType;
import domain.Generators.SpeelveldGenerator;
import domain.Route;
import javax.swing.JOptionPane;

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
        int aantalRijen = Integer.parseInt(JOptionPane.showInputDialog("Geef het aantal rijen in"));
        int aantalKolommen = Integer.parseInt(JOptionPane.showInputDialog("Geef het aantal kolommen in"));
        double verhoudingLeegMuren = Double.parseDouble(JOptionPane.showInputDialog("Geef de verhouding in tussen muren en lege velden in (Bijvoorbeeld 40)."
                + "\n" + "Hoe kleiner het getal, hoe meer muren de doolhof heeft"));

        VeldType speelveld[][] = new VeldType[aantalRijen][aantalKolommen];
        SpeelveldGenerator speelvgen = new SpeelveldGenerator(speelveld, aantalRijen, aantalKolommen, (verhoudingLeegMuren / 100));
        SpeelveldUI eenspeelveld = new SpeelveldUI(speelveld);

        Route route = eenspeelveld.geefRoute(eenspeelveld.getLeegKnooppunt(), eenspeelveld.getLeegKnooppunt());
        RouteUI eenRouteUI = new RouteUI(route);

//        Route korsteWeg = eenspeelveld.geefRoute(new Knooppunt(0,0), new Knooppunt(5,3));
        map.load(eenspeelveld, eenRouteUI);

        JOptionPane.showMessageDialog(map,
                "Startknooppunt: " + route.get(0).toString() + "\n"
                + "Eindknooppunt: " + route.get(route.size() -1).toString() + "\n"
                + "Afgelegde afstand:" + (route.size()-1)
        );

    }

}
