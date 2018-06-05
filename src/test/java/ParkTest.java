import Dinosaurs.*;
import Paddocks.DiplodocusPaddock;
import Paddocks.HoldingPaddock;
import Paddocks.RaptorPaddock;
import Park.Park;
import Visitors.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;
    RaptorPaddock raptorPaddock;
    DiplodocusPaddock diplodocusPaddock;
    HoldingPaddock holdingPaddock;
    Visitor visitor;
    Diplodocus diplodocus;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;

    @Before
    public void before(){
        park = new Park("Jurassic Park",3, 2);
        raptorPaddock = new RaptorPaddock("Raptor Kingdom", 3);
        diplodocusPaddock = new DiplodocusPaddock("Diplodocus Heaven", 10);
        holdingPaddock = new HoldingPaddock("Herbivore Safety", 5);
        velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE, SpeciesType.VELOCIRAPTOR,9,0.02,6.80);
        tyrannosaurus = new Tyrannosaurus("Teddy", DietType.CARNIVORE,SpeciesType.TYRANNOSAURUS,5,10.00,40.00);
        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, SpeciesType.DIPLODOCUS, 10, 15.00,90.00);
        visitor = new Visitor();
    }

    @Test
    public void canGetName() {
        assertEquals("Jurassic Park", park.getName());
    }

    @Test
    public void canGetVisitorCapacity(){
        assertEquals(3, park.getVisitorCapacity());
    }

    @Test
    public void visitorListStartsEmpty() {
        assertEquals(0, park.getVisitorCount());
    }

    @Test
    public void canAddVisitors() {
        park.addVisitor(visitor);
        assertEquals(1, park.getVisitorCount());
    }

    @Test
    public void canNotAddVisitorsIfAtCapacity(){
        park.addVisitor(visitor);
        park.addVisitor(visitor);
        park.addVisitor(visitor);
        park.addVisitor(visitor);
        assertEquals(3, park.getVisitorCapacity());
    }

    @Test
    public void canRemoveVisitors() {
        park.addVisitor(visitor);
        park.addVisitor(visitor);
        park.addVisitor(visitor);
        park.removeVisitor(visitor);
        assertEquals(2, park.getVisitorCount());
    }

    @Test
    public void paddockListStartsEmpty() {
        assertEquals(0, park.getPaddockCount());
    }

    @Test
    public void canAddPaddocks() {
        park.addPaddock(raptorPaddock);
        park.addPaddock(diplodocusPaddock);
        assertEquals(2, park.getPaddockCount());
    }

    @Test
    public void canNotAddPaddocksIfAtCapacity(){
        park.addPaddock(raptorPaddock);
        park.addPaddock(diplodocusPaddock);
        park.addPaddock(raptorPaddock);
        assertEquals(2, park.getPaddockCount());
    }

    @Test
    public void canRemovePaddocks() {
        park.addPaddock(raptorPaddock);
        park.addPaddock(diplodocusPaddock);
        park.removePaddock(diplodocusPaddock);
        assertEquals(1, park.getPaddockCount());
    }

//    @Test
//    public void checkIfHerbivore__true(){
//        diplodocusPaddock.addDinosaur(diplodocus);
//        assertEquals(true, park.checkIfHerbivore(diplodocus));
//    }
//
//    @Test
//    public void checkIfHerbivore__false(){
//        raptorPaddock.addDinosaur(velociraptor);
//        assertEquals(false, park.checkIfHerbivore(velociraptor));
//    }

    @Test
    public void canMoveHerbivoreBetweenPaddocks(){
        park.addPaddock(holdingPaddock);
        park.addPaddock(diplodocusPaddock);
        holdingPaddock.addDinosaur(diplodocus);
        holdingPaddock.addDinosaur(diplodocus);
        park.moveHerbivore(diplodocus, holdingPaddock, diplodocusPaddock);
        assertEquals(1, holdingPaddock.dinosaurListCount());
        assertEquals(1, diplodocusPaddock.dinosaurListCount());
    }

    @Test
    public void canNotMoveCarnivoreBetweenPaddocks(){
        park.addPaddock(raptorPaddock);
        park.addPaddock(holdingPaddock);
        raptorPaddock.addDinosaur(velociraptor);
        raptorPaddock.addDinosaur(velociraptor);
        park.moveHerbivore(velociraptor, raptorPaddock, holdingPaddock);
        assertEquals(2, raptorPaddock.dinosaurListCount());
        assertEquals(0, holdingPaddock.dinosaurListCount());
    }


}

