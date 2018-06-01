import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupTest {
    Group group = new Group("sport", 1);

    @Test
    public void testName(){
        assertEquals("sport", group.getName());
        assertEquals(1, group.getNumber());
    }

    @Test
    public void testMatch(){
        String[] atr = new String[]{"","","","","sport",""};
        assertTrue(group.match(atr));
    }

    @Test
    public void testMatchTwo(){
        String[] atr = new String[]{"","","","","","sport"};
        assertTrue(group.match(atr));
    }
}
