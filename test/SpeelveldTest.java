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

    Speelveld eenSpeelveld;

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
        
        initialiseerVeld1(eenVeldType1);
        
        

        eenSpeelveld = new Speelveld(eenVeldType1);
        System.out.println(eenSpeelveld.toString());
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
        assertEquals(verwachteRoute, eenSpeelveld.geefRoute(new Knooppunt(0, 0), new Knooppunt(3, 5)));
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

        /*...*/
    }
}
