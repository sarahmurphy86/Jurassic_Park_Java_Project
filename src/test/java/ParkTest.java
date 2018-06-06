import Dinosaurs.*;
import Paddocks.Paddock;
import Park.Park;
import Visitors.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;
    Paddock raptorPaddock;
    Paddock diplodocusPaddock;
    Paddock holdingPaddock;
    Visitor visitor;
    Diplodocus diplodocus;
    Velociraptor velociraptor;
    Tyrannosaurus tyrannosaurus;
    Triceretops triceretops;

    @Before
    public void before(){
        park = new Park("Jurassic Park",15.00,3, 2);
        raptorPaddock = new Paddock("Raptor Kingdom", 3);
        diplodocusPaddock = new Paddock("Diplodocus Heaven", 10);
        holdingPaddock = new Paddock("Herbivore Safety", 5);
        velociraptor = new Velociraptor("Vanessa",9,0.02,6.80);
        tyrannosaurus = new Tyrannosaurus("Teddy",5,10.00,40.00);
        diplodocus = new Diplodocus("Dippy", 10, 15.00,90.00);
        triceretops = new Triceretops("Tina",4, 11.00,30);
        visitor = new Visitor("Sophie", 28.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Jurassic Park", park.getName());
    }

    @Test
    public void canGetAdmissionPriceAdult(){
        assertEquals(15.00, park.getAdmissionPriceAdult(), 0.00);
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

//    Dinosaur used to disappear - i.e. it cant be added to to the raptorPaddock because there is a Velocirapor in there, but doesn't stay in the holdingPaddock- this has been fixed
    @Test
    public void canNotMoveHerbivoreIfCarnivorePresent(){
        park.addPaddock(raptorPaddock);
        park.addPaddock(holdingPaddock);
        raptorPaddock.addDinosaur(velociraptor);
        holdingPaddock.addDinosaur(diplodocus);
        park.moveHerbivore(diplodocus, holdingPaddock, raptorPaddock);
        assertEquals(1, raptorPaddock.dinosaurListCount());
        assertEquals(1, holdingPaddock.dinosaurListCount());
    }

    @Test
    public void canMoveVelociraptorSpeciesBetweenPaddocks(){
        park.addPaddock(holdingPaddock);
        park.addPaddock(raptorPaddock);
        holdingPaddock.addDinosaur(velociraptor);
        holdingPaddock.addDinosaur(velociraptor);
        park.moveVelociraptor(velociraptor,holdingPaddock,raptorPaddock);
        assertEquals(1, raptorPaddock.dinosaurListCount());
        assertEquals(1, holdingPaddock.dinosaurListCount());
    }
//Version1 - rampaging returns T or F

    @Test
    public void checkIfDinosaurIsRampaging(){
        park.addPaddock(holdingPaddock);
        holdingPaddock.addDinosaur(tyrannosaurus);
        assertEquals(true, park.checkIfDinosaurIsRampaging());
    }

    @Test
    public void checkIfDinosaurIsRampaging_False(){
        park.addPaddock(holdingPaddock);
        holdingPaddock.addDinosaur(diplodocus);
        assertEquals(false, park.checkIfDinosaurIsRampaging());
    }

    @Test
    public void canNotAddVisitorIfDinosaurRampaging(){
        park.addPaddock(holdingPaddock);
        holdingPaddock.addDinosaur(tyrannosaurus);
        park.addVisitor(visitor);
        assertEquals(0, park.getVisitorCount());
    }

    @Test
    public void canAddVisitorIfDinosaurIsNotRampaging(){
        park.addPaddock(holdingPaddock);
        holdingPaddock.addDinosaur(diplodocus);
        park.addVisitor(visitor);
        assertEquals(1, park.getVisitorCount());
    }

    @Test
    public void canFindOutHowManyDinosaursAreInAllThePaddocks(){
        park.addPaddock(holdingPaddock);
        holdingPaddock.addDinosaur(diplodocus);
        park.addPaddock(raptorPaddock);
        raptorPaddock.addDinosaur(velociraptor);
        assertEquals(2,park.totalDinosaursInAllPaddocks());
    }

    @Test
    public void canFindOutTotalAmountTakenInAdmissions(){
        park.addVisitor(visitor);
        park.addVisitor(visitor);
        assertEquals(30.00, park.getAdmissionsTotal(), 0.00);
    }


}

