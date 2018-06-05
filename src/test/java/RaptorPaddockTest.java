import Dinosaurs.*;
import Paddocks.DiplodocusPaddock;
import Paddocks.RaptorPaddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaptorPaddockTest {

    RaptorPaddock raptorPaddock;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;


    @Before
    public void before() {
        raptorPaddock = new RaptorPaddock("Raptor Kingdom", 3);
        velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE,SpeciesType.VELOCIRAPTOR,9,0.02,6.80);
        tyrannosaurus = new Tyrannosaurus("Teddy", DietType.CARNIVORE,SpeciesType.TYRANNOSAURUS,5,10.00,40.00);
    }

    @Test
    public void canGetPaddockName(){
        assertEquals("Raptor Kingdom", raptorPaddock.getPaddockName());
    }

    @Test
    public void canGetPaddockCapacity(){
        assertEquals(3, raptorPaddock.getPaddockCapacity());
    }

    @Test
    public void paddockStartsEmpty() {
        assertEquals(0, raptorPaddock.dinosaurListCount());
    }

    @Test
    public void canAddDinosaursToPaddockIfSameSpecies() {
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        assertEquals(2, raptorPaddock.dinosaurListCount());
    }

    @Test
    public void canNotAddDinosaursToPaddockIfNotSameSpecies(){
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(tyrannosaurus);
        assertEquals(1, raptorPaddock.dinosaurListCount());
    }

    @Test
    public void canNotAddDinosaursToPaddockIfAtCapacity(){
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        assertEquals(3, raptorPaddock.dinosaurListCount());
    }

    @Test
    public void canRemoveDinosaursFromPaddock(){
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.removeDinosaur();
        assertEquals(1, raptorPaddock.dinosaurListCount());
    }



}
