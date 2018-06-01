import org.junit.Test;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AddressTest {
    private Address johnnywalker;

    private void init(){
        johnnywalker = new Address("Johnny Walker",
                "Road McLeod, 3604 Edinburgh",
                "0222264918",
                "johnny@walker.co.uk");
    }

    @Test
    public void testInit(){
        init();
        assertEquals("Johnny Walker", johnnywalker.getName());
        assertEquals("Road McLeod, 3604 Edinburgh", johnnywalker.getPhysical_address());
        assertEquals("0222264918", johnnywalker.getPhone_number());
        assertEquals("johnny@walker.co.uk", johnnywalker.getEmail());
    }

    @Test
    public void testMatchName(){
        init();
        String[] attributes = {"Johnny","","","","",""};
        assertTrue(johnnywalker.match(attributes));
    }

    @Test
    public void testNotMatch(){
        init();
        String[] attributes = {"Johnny English","","","","",""};
        assertFalse(johnnywalker.match(attributes));
    }

    @Test
    public void testMatchAdr(){
        init();
        String[] attributes = {"","Edinburgh","","","",""};
        assertTrue(johnnywalker.match(attributes));
    }

    @Test
    public void testMatchPhone(){
        init();
        String[] attributes = {"","","022","","",""};
        assertTrue(johnnywalker.match(attributes));
    }

    @Test
    public void testMatchEmail(){
        init();
        String[] attributes = {"","","","@walker.co.uk","",""};
        assertTrue(johnnywalker.match(attributes));
    }

    @Test
    public void testMatchAny(){
        init();
        String[] attributes = {"","","","","","john"};
        assertTrue(johnnywalker.match(attributes));
    }

    @Test
    public void testCaseInsensitive(){
        init();
        String[] attributes = {"walker","","","","",""};
        assertTrue(johnnywalker.match(attributes));
    }
}
