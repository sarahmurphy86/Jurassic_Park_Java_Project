import Dinosaurs.DietType;
import Dinosaurs.Diplodocus;
import Paddocks.DiplodocusPaddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiplodocusPaddockTest {

    DiplodocusPaddock diplodocusPaddock;
    Diplodocus diplodocus;


    @Before
    public void before() {
        diplodocusPaddock = new DiplodocusPaddock("Diplodocus Heaven", 5);
        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);
    }

    @Test
    public void canGetPaddockName(){
        assertEquals("Diplodocus Heaven", diplodocusPaddock.getPaddockName());
    }

    @Test
    public void paddockStartsEmpty() {
        assertEquals(0, diplodocusPaddock.dinosaurListCount());

    }
}
