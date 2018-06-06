import Dinosaurs.*;
import Paddocks.Paddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockTest {

    Paddock raptorPaddock;
    Paddock diplodocusPaddock;
    Paddock holdingPaddock;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;
    Diplodocus diplodocus;
    Triceretops triceretops;


    @Before
    public void before() {
        raptorPaddock = new Paddock("Raptor Kingdom", 3);
        diplodocusPaddock = new Paddock("Diplodocus Heaven", 5);
        holdingPaddock = new Paddock("Herbivore Safety", 5);
        velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE, SpeciesType.VELOCIRAPTOR,9,0.02,6.80);
        tyrannosaurus = new Tyrannosaurus("Teddy", DietType.CARNIVORE,SpeciesType.TYRANNOSAURUS,5,10.00,40.00);
        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, SpeciesType.DIPLODOCUS, 10, 15.00, 90.00);
        triceretops = new Triceretops("Tina",4, 11.00,30);
    }

    @Test
    public void canGetPaddockName() {
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
    public void canAddDinosaursToPaddock(){
        diplodocusPaddock.addDinosaur(diplodocus);
        assertEquals(1, diplodocusPaddock.dinosaurListCount());
        assertEquals("Dippy", diplodocusPaddock.dinosaurList.get(0).getName());
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

    @Test
    public void canAddDinosaursToPaddockIfSameSpecies() {
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        assertEquals(2, raptorPaddock.dinosaurListCount());
    }

    @Test
    public void canNotAddDinosaursToPaddockIfNotSameSpecies__Carnivore(){
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(tyrannosaurus);
        assertEquals(1, raptorPaddock.dinosaurListCount());
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

