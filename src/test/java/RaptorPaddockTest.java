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
    Diplodocus diplodocus;


    @Before
    public void before() {
        raptorPaddock = new RaptorPaddock("Raptor Kingdom", 3);
        velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE, 9, 0.02, 6.8);
        tyrannosaurus = new Tyrannosaurus("Teddy", DietType.CARNIVORE, 5, 10.00, 40.0);
        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);
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
    public void canAddDinosaursToPaddock(){
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(tyrannosaurus);
        assertEquals(2, raptorPaddock.dinosaurListCount());
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
        raptorPaddock.addDinosaur(tyrannosaurus);
        raptorPaddock.addDinosaur(diplodocus);
        raptorPaddock.removeDinosaur();
        assertEquals(2, raptorPaddock.dinosaurListCount());
    }

//    The below is not right- I don't want to have to specify the dinosaur.

    @Test
    public void canRemoveHerbivoreFromPaddock(){
        raptorPaddock.addDinosaur(tyrannosaurus);
        raptorPaddock.addDinosaur(diplodocus);
        raptorPaddock.removeHerbivore(diplodocus);
        assertEquals(1,raptorPaddock.dinosaurListCount());
    }

    @Test
    public void canRemoveHerbivoreFromPaddock_false(){
        raptorPaddock.addDinosaur(tyrannosaurus);
        raptorPaddock.addDinosaur(diplodocus);
        raptorPaddock.removeHerbivore(tyrannosaurus);
        assertEquals(2,raptorPaddock.dinosaurListCount());
    }


//    **WORK ON THE BELOW**

//
//
//Example from internet - moving objects between arraylists when the arraylists are in the same class
//    public boolean sellCar(Car c) {
//        if(carsAvailable.remove(c)) {
//            carsSold.add(c);
//            return true;
//        }
//        else return false;
//    }
//
//    @Test
//    public void canTransferHerbivoreBetweenPaddocks(){
//        raptorPaddock.addDinosaur(tyrannosaurus);
//        raptorPaddock.addDinosaur(diplodocus);
//        raptorPaddock.moveDinosaur(diplodocus);
//        assertEquals(1, raptorPaddock.dinosaurListCount());
//        assertEquals(1, diplodocusPaddock.dinosaurListCount());
//    }
//

}
