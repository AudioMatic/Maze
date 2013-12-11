/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


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
    protected VeldType speelveld[][];

    public Speelveld(int dimrij, int dimkol) {

    }

    public Speelveld(VeldType[][] speelveld) {
        setSpeelveld(speelveld);
    }

    private void setSpeelveld(VeldType[][] speelveld)throws IllegalArgumentException {
        if(speelveld == null) throw new IllegalArgumentException("Er is geen speelveld meegegeven");
        if(speelveld.length > 200) throw new IllegalArgumentException("Je kan maar maximaal 200 rijen opgeven");
        if(speelveld[0].length > 200) throw new IllegalArgumentException("Je kan maar maximaal 200 kolommen opgeven");
        if(speelveld.length <= 1) throw new IllegalArgumentException("Je kan minimaal maar 2 voor rij ingeven");
        if(speelveld[0].length <= 1) throw new IllegalArgumentException("Je kan minimaal maar 2 voor kolom ingeven");
        this.speelveld = speelveld;
    }

    
    /**
     * 
     * @param start startknooppunt
     * @param stop eindknooppunt
     * @return de kortste route
     * @throws IllegalArgumentException 
     */
    public Route geefRoute(Knooppunt start, Knooppunt stop) throws IllegalArgumentException {
        if(knooppuntOpMuur(stop) == true || knooppuntOpMuur(start) == true) throw new IllegalArgumentException("start en/of stop mogen niet op een muur vallen");

        if (start.equals(stop)) {
            Route routeNaarZelfdePunt = new Route();
            routeNaarZelfdePunt.appendKnooppunt(start);
            routeNaarZelfdePunt.appendKnooppunt(stop);

            return routeNaarZelfdePunt;

        }
        RouteMetaData bezochtevelden[][] = new RouteMetaData[this.speelveld.length][this.speelveld[0].length];
        bezoekVeld(start, bezochtevelden, null, 0);

        printBezochteVelden(bezochtevelden);

        return contrueerRoute(bezochtevelden, stop);

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
     * @param start startknooppunt
     * @param bezocht : een dubbele array bestaande uit routemetadata die afstand en de vorige stap bijhouden
     * Hiermee bezoek je alle mogelijke velden die je vanaf het startknooppunt kan bezoeken.
     * Dit stopt wanneer je geen veld meer kan bezoeken die null is of de afstand van dat veld kleiner is dan jouw afgelegde afstand tot nu toe
     * 
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
        if (noord.rij >= 0 && (bezocht[noord.rij][noord.kol] == null
                || afstand < bezocht[noord.rij][noord.kol].afstand) && this.speelveld[noord.rij][noord.kol] != VeldType.MUUR) {

            bezoekVeld(noord, bezocht, knooppunt, afstand + 1);
        }

        //Zuid
        Knooppunt zuid = new Knooppunt(knooppunt.rij + 1, knooppunt.kol);
        if (zuid.rij < bezocht.length && (bezocht[zuid.rij][zuid.kol] == null
                || afstand < bezocht[zuid.rij][zuid.kol].afstand) && this.speelveld[zuid.rij][zuid.kol] != VeldType.MUUR) {

            bezoekVeld(zuid, bezocht, knooppunt, afstand + 1);
        }

        //Oost
        Knooppunt oost = new Knooppunt(knooppunt.rij, knooppunt.kol + 1);
        if (oost.kol < bezocht[0].length && (bezocht[oost.rij][oost.kol] == null
                || afstand < bezocht[oost.rij][oost.kol].afstand) && this.speelveld[oost.rij][oost.kol] != VeldType.MUUR) {

            bezoekVeld(oost, bezocht, knooppunt, afstand + 1);
        }

        //West
        Knooppunt west = new Knooppunt(knooppunt.rij, knooppunt.kol - 1);
        if (west.kol >= 0 && (bezocht[west.rij][west.kol] == null
                || afstand < bezocht[west.rij][west.kol].afstand) && this.speelveld[west.rij][west.kol] != VeldType.MUUR) {
            // 
            bezoekVeld(west, bezocht, knooppunt, afstand + 1);
        }

    }
    
    /**
     * 
     * @return Een willekeurig knooppunt op het speelveld.
     */
    public Knooppunt getLeegKnooppunt() {

        int maxRij = this.speelveld.length;
        int maxKol = this.speelveld[0].length;
        int rangeRij = maxRij - 1;
        int rangeKol = maxKol - 1;
        int rij = (int) (Math.random() * rangeRij);
        int kol = (int) (Math.random() * rangeKol);
        Knooppunt knooppunt = new Knooppunt(rij, kol);
        while (knooppuntOpMuur(knooppunt) == true) {
            rij = (int) (Math.random() * rangeRij);
            kol = (int) (Math.random() * rangeKol);
            knooppunt.rij = rij;
            knooppunt.kol = kol;
        }

        return knooppunt;

    }

    private boolean knooppuntOpMuur(Knooppunt knooppunt) {
        return (this.speelveld[knooppunt.rij][knooppunt.kol] == Speelveld.VeldType.MUUR);

    }
    
    /**
     * 
     * @param routemd : velden bestaande uit routemetadata
     * @param eind : eindknooppunt
     * @return : geeft de korste route terug door alle vorige stappen terug te nemen tot het startknooppunt
     *             want die geeft als vorigestap null terug.
     */
    

    private Route contrueerRoute(RouteMetaData routemd[][], Knooppunt eind) {
        Route korsteRoute = null;

        if (routemd[eind.rij][eind.kol] != null) {
            korsteRoute = new Route();
            Knooppunt huidig = eind;
            while (huidig != null) {
                korsteRoute.prependKnooppunt(huidig);
                huidig = routemd[huidig.rij][huidig.kol].vorigeStap;

            }
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

    private void printBezochteVelden(RouteMetaData[][] bezochtevelden) {
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < bezochtevelden.length; i++) {
            for (int j = 0; j < bezochtevelden[i].length; j++) {

                if (bezochtevelden[i][j] != null) {
                    System.out.print(bezochtevelden[i][j].afstand + " ");
                } else {
                    System.out.print("X ");
                }

            }
            System.out.println("");
        }

    }
}

/**
 * TODO
 *
 * 1. Rekening houden met u afstand (bepaalde plaatsen zal je meerdere keren
 * moeten bezoeken) 2. Effectieve route contrueert adhv alle vorige stappen
 *
 *
 *
 * 1 Zorgen voor dat de Unit test macheert 2 Maak een nieuwe test met een nieuw
 * speelveld waarbij er tussen het start en het eindpunt geen route mogelijk is.
 *
 */
