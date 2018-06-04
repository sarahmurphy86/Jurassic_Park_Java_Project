import Dinosaurs.DietType;
import Dinosaurs.Diplodocus;
import Paddocks.DiplodocusPaddock;
import Paddocks.HoldingPaddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HoldingPaddockTest {

    HoldingPaddock holdingPaddock;
    Diplodocus diplodocus;

    @Before
    public void before() {
      holdingPaddock = new HoldingPaddock("Herbivore Safety", 5);
      diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);
    }

    @Test
    public void canGetPaddockName(){
        assertEquals("Herbivore Safety", holdingPaddock.getPaddockName());
    }
}
