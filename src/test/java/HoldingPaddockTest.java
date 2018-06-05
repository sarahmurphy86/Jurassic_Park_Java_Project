import Dinosaurs.*;
import Paddocks.DiplodocusPaddock;
import Paddocks.HoldingPaddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HoldingPaddockTest {

    HoldingPaddock holdingPaddock;
    Diplodocus diplodocus;
    Triceretops triceretops;
    Velociraptor velociraptor;

    @Before
    public void before() {
      holdingPaddock = new HoldingPaddock("Herbivore Safety", 5);
      diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, SpeciesType.DIPLODOCUS, 10, 15.00, 90.00);
      triceretops = new Triceretops("Tina", DietType.HERBIVORE, SpeciesType.TRICERATOPS, 4, 11.00,30);
      velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE,SpeciesType.VELOCIRAPTOR,9,0.02,6.80);

    }

    @Test
    public void canGetPaddockName(){
        assertEquals("Herbivore Safety", holdingPaddock.getPaddockName());
    }

    @Test
    public void canAddDinosaursToPaddockIfSameDietType_Herbivore(){
        holdingPaddock.addDinosaur(diplodocus);
        holdingPaddock.addDinosaur(triceretops);
        assertEquals(2, holdingPaddock.dinosaurListCount());
    }

    @Test
    public void canNotAddCarnivoreToHerbivorePaddock(){
        holdingPaddock.addDinosaur(diplodocus);
        holdingPaddock.addDinosaur(triceretops);
        holdingPaddock.addDinosaur(velociraptor);
        assertEquals(2, holdingPaddock.dinosaurListCount());
    }
}
