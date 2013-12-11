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
    static int aantalRijen = 0;
    static int aantalKolommen = 0;
    static double verhoudingLeegMuren = 0;
    static VeldType speelveld[][] = null;
    static SpeelveldUI eenspeelveld = null;
    static RouteUI eenRouteUI = null;
    static Route route = null;

    public static void main(String[] args) {
        CanvasJFrame map = new CanvasJFrame();
        String invAantalRijen = null;
        String invAantalKolommen = null;
        String invVerhouding = null;

        invAantalRijen = JOptionPane.showInputDialog("Geef het aantal rijen in");
        if (invAantalRijen == null) {
            System.exit(0);
        } else {
            boolean isEenGetal = false;
            while (isEenGetal == false) {
                try {
                    aantalRijen = Integer.parseInt(invAantalRijen);
                    isEenGetal = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(map, "Je moet een geheel getal in geven");
                    invAantalRijen = JOptionPane.showInputDialog("Geef het aantal rijen in");
                }

            }
        }
        aantalKolommen = Integer.parseInt(JOptionPane.showInputDialog("Geef het aantal kolommen in"));
        verhoudingLeegMuren = Double.parseDouble(JOptionPane.showInputDialog("Geef de verhouding in tussen muren en lege velden in (Bijvoorbeeld 40)."
                + "\n" + "Hoe kleiner het getal, hoe meer muren de doolhof heeft"));

        try {
            speelveld = new VeldType[aantalRijen][aantalKolommen];
            SpeelveldGenerator speelvgen = new SpeelveldGenerator(speelveld, aantalRijen, aantalKolommen, (verhoudingLeegMuren / 100));
            eenspeelveld = new SpeelveldUI(speelveld);
            route = eenspeelveld.geefRoute(eenspeelveld.getLeegKnooppunt(), eenspeelveld.getLeegKnooppunt());
            eenRouteUI = new RouteUI(route);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(map, e.getMessage());
        }

//        Route korsteWeg = eenspeelveld.geefRoute(new Knooppunt(0,0), new Knooppunt(5,3));
        map.load(eenspeelveld, eenRouteUI);

        JOptionPane.showMessageDialog(map,
                "Startknooppunt: " + route.get(0).toString() + "\n"
                + "Eindknooppunt: " + route.get(route.size() - 1).toString() + "\n"
                + "Afgelegde afstand:" + (route.size() - 1)
        );

    }

}
