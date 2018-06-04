import Dinosaurs.DietType;
import Dinosaurs.Diplodocus;
import Dinosaurs.Velociraptor;
import Paddocks.DiplodocusPaddock;
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
    Visitor visitor;
    Diplodocus diplodocus;
    Velociraptor velociraptor;

    @Before
    public void before(){
        park = new Park("Jurassic Park",3, 2);
        raptorPaddock = new RaptorPaddock("Raptor Kingdom", 3);
        velociraptor = new Velociraptor("Vanessa", DietType.CARNIVORE, 9, 0.02, 6.8);
        diplodocusPaddock = new DiplodocusPaddock("Diplodocus Heaven", 10);
        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);
        visitor = new Visitor();
    }

    @Test
    public void canGetName() {
        assertEquals("Jurassic Park", park.getName());
    }

    @Test
    public void canGetVisitorCapacity(){
        assertEquals(2, park.getVisitorCapacity());
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

    @Test
    public void checkIfHerbivore__true(){
        diplodocusPaddock.addDinosaur(diplodocus);
        assertEquals(true, park.checkIfHerbivore(diplodocus));
    }

    @Test
    public void checkIfHerbivore__false(){
        raptorPaddock.addDinosaur(velociraptor);
        assertEquals(false, park.checkIfHerbivore(velociraptor));
    }

//    @Test
//    public void canMoveHerbivoreBetweenPaddocks(){
//        park.addPaddock(raptorPaddock);
//        park.addPaddock(diplodocusPaddock);
//        raptorPaddock.addDinosaur(velociraptor);
//        raptorPaddock.addDinosaur(diplodocus);
//        park.moveHerbivore();
//        assertEquals(1, raptorPaddock.dinosaurListCount());
//        assertEquals(1,diplodocusPaddock.dinosaurListCount());
//    }

}

