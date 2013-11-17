/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import ui.Launcher;

/**
 *
 * @author AudioMatic
 */
public class Speelveld {

    private static class routemd {

        public routemd() {
        }
    }

    public enum VeldType {

        LEEG,
        MUUR;

        @Override
        public String toString() {
            switch (this) {
                case LEEG:
                    return "0";
                case MUUR:
                    return "X";
                default:
                    throw new IllegalArgumentException();

            }


        }
    }
    private VeldType speelveld[][];

    public Speelveld(VeldType[][] speelveld) {
        setSpeelveld(speelveld);
    }

    private void setSpeelveld(VeldType[][] speelveld) {
        this.speelveld = speelveld;
    }

    public Route geefRoute(Knooppunt start, Knooppunt stop) {
        
        RouteMetaData bezochtevelden[][] = new RouteMetaData[this.speelveld.length][this.speelveld[0].length];
        bezoekVeld(start, bezochtevelden, null, 0);

        return contrueerRoute(bezochtevelden , stop);

    }

    /**
     * Metadata voor route
     */
    class RouteMetaData {

        public int afstand = 0;
        Knooppunt vorigeStap = null;
    }

    /**
     *
     * @param start
     * @param bezocht
     *
     * Zoek alle mogelijke velden die je kan bezoeken Het kan ook best mogelijk
     * zijn dat je hetzelfde veld moet bezoeken eer dat je aan u bestemming
     * bent.
     */
    private void bezoekVeld(Knooppunt knooppunt, RouteMetaData bezocht[][], Knooppunt prevKnooppunt, int afstand) {
        RouteMetaData routemd = new RouteMetaData();

        routemd.vorigeStap = prevKnooppunt;
        routemd.afstand = afstand;
        bezocht[knooppunt.rij][knooppunt.kol] = routemd;


        /**
         * Bepaal welke kant je uitgaat
         */
        //Noord
        Knooppunt noord = new Knooppunt(knooppunt.rij - 1, knooppunt.kol);
        if (noord.rij >= 0 && bezocht[noord.rij][noord.kol] == null && this.speelveld[noord.rij][noord.kol] != VeldType.MUUR) {

            bezoekVeld(noord, bezocht, knooppunt, afstand + 1);
        }

        //Zuid
        Knooppunt zuid = new Knooppunt(knooppunt.rij + 1, knooppunt.kol);
        if (zuid.rij < bezocht.length && bezocht[zuid.rij][zuid.kol] == null && this.speelveld[zuid.rij][zuid.kol] != VeldType.MUUR) {

            bezoekVeld(zuid, bezocht, knooppunt, afstand + 1);
        }

        //Oost
        Knooppunt oost = new Knooppunt(knooppunt.rij, knooppunt.kol + 1);
        if (oost.kol < bezocht[0].length && bezocht[oost.rij][oost.kol] == null && this.speelveld[oost.rij][oost.kol] != VeldType.MUUR) {

            bezoekVeld(oost, bezocht, knooppunt, afstand + 1);
        }

        //West
        Knooppunt west = new Knooppunt(knooppunt.rij, knooppunt.kol - 1);
        if (west.kol >= 0 && bezocht[west.rij][west.kol] == null && this.speelveld[west.rij][west.kol] != VeldType.MUUR) {
            // 
            bezoekVeld(west, bezocht, knooppunt, afstand + 1);
        }



    }

    private Route contrueerRoute(RouteMetaData routemd[][], Knooppunt eind) {
        Route korsteRoute = new Route();
        
        Knooppunt huidig = eind;
        
        while (huidig != null) {
            korsteRoute.prependKnooppunt(huidig);
            huidig = routemd[huidig.rij][huidig.kol].vorigeStap;
            
        }
        
        return korsteRoute;

    }

    
    @Override
    public String toString() {
        StringBuffer out = new StringBuffer();


        for (int i = 0; i < this.speelveld.length; i++) {
            for (int j = 0; j < this.speelveld[i].length; j++) {

                out.append(this.speelveld[i][j].toString());

            }
            out.append("\n");
        }


        return out.toString();
    }
}


/**
 * TODO
 * 
 * 1. Rekening houden met u afstand (bepaalde plaatsen zal je meerdere keren moeten bezoeken)
 * 2. Effectieve route contrueert adhv alle vorige stappen
 * 
 */