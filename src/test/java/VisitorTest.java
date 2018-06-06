import Visitors.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;

    @Before
    public void before(){
        visitor = new Visitor ("Sophie", 120.00);
    }

    @Test
    public void canGetName(){
        assertEquals("Sophie", visitor.getName());
    }

    @Test
    public void canGetWallet(){
        assertEquals(120.00, visitor.getWallet(), 0.00);
    }
}
