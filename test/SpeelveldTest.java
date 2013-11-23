/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Knooppunt;
import domain.Route;
import domain.Speelveld;
import domain.Speelveld.VeldType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AudioMatic
 */
public class SpeelveldTest {

    Speelveld eenSpeelveld1;
    Speelveld eenSpeelveld2;
    Speelveld eenSpeelveld3;

    public SpeelveldTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        VeldType[][] eenVeldType1 = new VeldType[5][6]; // Rij / kolom
        VeldType[][] eenVeldType2 = new VeldType[5][6]; // Rij / kolom
        VeldType[][] eenVeldType3 = new VeldType[5][6]; // Rij / kolom

        //initialiseer velden
        initialiseerVeld1(eenVeldType1);
        initialiseerVeld2(eenVeldType2);
        initialiseerVeld3(eenVeldType3);

        eenSpeelveld1 = new Speelveld(eenVeldType1);
        System.out.println(eenSpeelveld1.toString());
        System.out.println("");
        eenSpeelveld2 = new Speelveld(eenVeldType2);
        System.out.println(eenSpeelveld1.toString());
        System.out.println("");

        eenSpeelveld3 = new Speelveld(eenVeldType3);
        System.out.println(eenSpeelveld3.toString());
        System.out.println("");
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void korsteRoute1() {

        Route verwachteRoute = new Route();
        verwachteRoute.appendKnooppunt(new Knooppunt(0, 0));
        verwachteRoute.appendKnooppunt(new Knooppunt(1, 0));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 0));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 1));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 2));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 3));
        verwachteRoute.appendKnooppunt(new Knooppunt(1, 3));
        verwachteRoute.appendKnooppunt(new Knooppunt(0, 3));
        verwachteRoute.appendKnooppunt(new Knooppunt(0, 4));
        verwachteRoute.appendKnooppunt(new Knooppunt(0, 5));
        verwachteRoute.appendKnooppunt(new Knooppunt(1, 5));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 5));
        verwachteRoute.appendKnooppunt(new Knooppunt(3, 5));
        assertEquals(verwachteRoute, eenSpeelveld1.geefRoute(new Knooppunt(0, 0), new Knooppunt(3, 5)));
    }

    @Test
    public void korsteRoute2() {

        Route verwachteRoute = new Route();
        verwachteRoute.appendKnooppunt(new Knooppunt(0, 0));
        verwachteRoute.appendKnooppunt(new Knooppunt(1, 0));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 0));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 1));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 2));
        verwachteRoute.appendKnooppunt(new Knooppunt(2, 3));
        verwachteRoute.appendKnooppunt(new Knooppunt(3, 3));
        verwachteRoute.appendKnooppunt(new Knooppunt(3, 4));
        verwachteRoute.appendKnooppunt(new Knooppunt(3, 5));

        assertEquals(verwachteRoute, eenSpeelveld2.geefRoute(new Knooppunt(0, 0), new Knooppunt(3, 5)));
    }

    private void initialiseerVeld1(VeldType[][] eenVeldType1) {

        for (int i = 0; i < eenVeldType1.length; i++) {
            for (int j = 0; j < eenVeldType1[i].length; j++) {
                eenVeldType1[i][j] = VeldType.LEEG;
            }
        }

        eenVeldType1[0][1] = VeldType.MUUR;
        eenVeldType1[1][1] = VeldType.MUUR;
        eenVeldType1[1][2] = VeldType.MUUR;
        eenVeldType1[1][4] = VeldType.MUUR;
        eenVeldType1[2][4] = VeldType.MUUR;
        eenVeldType1[3][0] = VeldType.MUUR;
        eenVeldType1[3][1] = VeldType.MUUR;
        eenVeldType1[3][2] = VeldType.MUUR;
        eenVeldType1[3][4] = VeldType.MUUR;
        eenVeldType1[4][2] = VeldType.MUUR;
        eenVeldType1[4][4] = VeldType.MUUR;

    }

    private void initialiseerVeld2(VeldType[][] eenVeldType2) {

        for (int i = 0; i < eenVeldType2.length; i++) {
            for (int j = 0; j < eenVeldType2[i].length; j++) {
                eenVeldType2[i][j] = VeldType.LEEG;
            }
        }

        eenVeldType2[0][1] = VeldType.MUUR;
        eenVeldType2[1][1] = VeldType.MUUR;
        eenVeldType2[1][2] = VeldType.MUUR;
        eenVeldType2[1][4] = VeldType.MUUR;
        eenVeldType2[2][4] = VeldType.MUUR;
        eenVeldType2[3][0] = VeldType.MUUR;
        eenVeldType2[3][1] = VeldType.MUUR;
        eenVeldType2[3][2] = VeldType.MUUR;
        //     eenVeldType2[3][4] = VeldType.MUUR;
        eenVeldType2[4][2] = VeldType.MUUR;
        eenVeldType2[4][4] = VeldType.MUUR;

    }

    private void initialiseerVeld3(VeldType[][] eenVeldType3) {

        for (int i = 0; i < eenVeldType3.length; i++) {
            for (int j = 0; j < eenVeldType3[i].length; j++) {
                eenVeldType3[i][j] = VeldType.LEEG;
            }
        }

        eenVeldType3[0][1] = VeldType.MUUR;
        eenVeldType3[1][1] = VeldType.MUUR;
        eenVeldType3[1][2] = VeldType.MUUR;
        eenVeldType3[1][4] = VeldType.MUUR;
        eenVeldType3[2][4] = VeldType.MUUR;
        eenVeldType3[3][0] = VeldType.MUUR;
        eenVeldType3[3][1] = VeldType.MUUR;
        eenVeldType3[3][2] = VeldType.MUUR;
        eenVeldType3[3][4] = VeldType.MUUR;
        eenVeldType3[4][2] = VeldType.MUUR;
        eenVeldType3[4][4] = VeldType.MUUR;
        eenVeldType3[1][5] = VeldType.MUUR;

    }

}
