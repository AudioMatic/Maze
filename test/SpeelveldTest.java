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
    Speelveld eenSpeelveld ;
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
        VeldType[][] eenVeldType = new VeldType[5][6];
        for(int i = 0 ; i < eenVeldType.length ; i ++){
            for(int j = 0 ; j < eenVeldType[i].length ; j ++){
                eenVeldType[i][j] = VeldType.LEEG;
            }
        }
        
        
        
        eenVeldType[0][1] = VeldType.MUUR;
         eenVeldType[1][1] = VeldType.MUUR;
         eenVeldType[1][2] = VeldType.MUUR;
         eenVeldType[1][4] = VeldType.MUUR;
         eenVeldType[2][4] = VeldType.MUUR;
         eenVeldType[3][0] = VeldType.MUUR;
         eenVeldType[3][1] = VeldType.MUUR;
         eenVeldType[3][2] = VeldType.MUUR;
         eenVeldType[3][4] = VeldType.MUUR;
         eenVeldType[4][2] = VeldType.MUUR;
         eenVeldType[4][4] = VeldType.MUUR;
         
        /*...*/
         
        eenSpeelveld = new Speelveld(eenVeldType);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void korsteRoute() {
        
        Route verwachteRoute = new Route();
        verwachteRoute.addKnooppunt(new Knooppunt(0, 0));
        verwachteRoute.addKnooppunt(new Knooppunt(1, 0));
        verwachteRoute.addKnooppunt(new Knooppunt(2, 0));
        verwachteRoute.addKnooppunt(new Knooppunt(2, 1));
        verwachteRoute.addKnooppunt(new Knooppunt(2, 2));
        verwachteRoute.addKnooppunt(new Knooppunt(2, 3));
        verwachteRoute.addKnooppunt(new Knooppunt(3, 3));
        verwachteRoute.addKnooppunt(new Knooppunt(3, 4));
        verwachteRoute.addKnooppunt(new Knooppunt(3, 5));
        assertEquals(verwachteRoute,eenSpeelveld.geefRoute(new Knooppunt(0, 0),new Knooppunt(3, 5)));
    }
}
