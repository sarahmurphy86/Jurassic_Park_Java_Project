import Visitors.Visitor;
import Park.Park;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Park park;

    @Before
    public void before(){
        visitor = new Visitor ("Sophie", 120.00);
        park = new Park("Jurassic Park",15.00,3, 2);
    }

    @Test
    public void canGetName(){
        assertEquals("Sophie", visitor.getName());
    }

    @Test
    public void canGetWallet(){
        assertEquals(120.00, visitor.getWallet(), 0.00);
    }

    @Test
    public void canPayAdmissionFee(){
        visitor.payAdmissionFee(park);
        assertEquals(105, visitor.getWallet(), 0.00);

    }


}
