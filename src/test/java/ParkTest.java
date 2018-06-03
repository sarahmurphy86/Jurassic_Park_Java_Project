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

    @Before
    public void before(){
        park = new Park("Jurassic Park");
        raptorPaddock = new RaptorPaddock("Raptor Kingdom", 3);
        diplodocusPaddock = new DiplodocusPaddock("Diplodocus Heaven", 10);
        visitor = new Visitor();
    }

    @Test
    public void canGetName() {
        assertEquals("Jurassic Park", park.getName());
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
    public void canRemovePaddocks() {
        park.addPaddock(raptorPaddock);
        park.addPaddock(diplodocusPaddock);
        park.removePaddock(diplodocusPaddock);
        assertEquals(1, park.getPaddockCount());
    }

}
