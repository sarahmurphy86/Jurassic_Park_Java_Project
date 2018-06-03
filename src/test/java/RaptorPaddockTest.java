import Dinosaurs.DietType;
import Dinosaurs.Diplodocus;
import Dinosaurs.Tyrannosaurus;
import Dinosaurs.Velociraptor;
import Paddocks.RaptorPaddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaptorPaddockTest {

    RaptorPaddock raptorPaddock;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;
    Diplodocus diplodocus;


    @Before
    public void before() {
        raptorPaddock = new RaptorPaddock("Raptor Kingdom");
        velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE, 9, 0.02, 6.8);
        tyrannosaurus = new Tyrannosaurus("Teddy", DietType.CARNIVORE, 5, 10.00, 40.0);
        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);
    }

    @Test
    public void canGetPaddockName(){
        assertEquals("Raptor Kingdom", raptorPaddock.getPaddockName());
    }


}
