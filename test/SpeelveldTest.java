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
        eenVeldType[0][1] = VeldType.MUUR;
         eenVeldType[0][2] = VeldType.MUUR;
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
        verwachteRoute.addKnooppunt(new Knooppunt(0, 1));
        verwachteRoute.addKnooppunt(new Knooppunt(0, 2));
        verwachteRoute.addKnooppunt(new Knooppunt(1, 2));
        verwachteRoute.addKnooppunt(new Knooppunt(2, 2));
        verwachteRoute.addKnooppunt(new Knooppunt(3, 2));
        verwachteRoute.addKnooppunt(new Knooppunt(3, 3));
        verwachteRoute.addKnooppunt(new Knooppunt(4, 3));
        verwachteRoute.addKnooppunt(new Knooppunt(5, 3));
        assertEquals(eenSpeelveld.geefRoute(new Knooppunt(0, 0),new Knooppunt(5, 3)), verwachteRoute);
    }
}
