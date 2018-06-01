import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.LinkedList;


public class InputReaderTest {

    private LinkedList<Address> parsedAdr;
    private LinkedList<Group> parsedGroup;
    private InputReader reader;

    private void instantiate(){
        File file = new File("test/addressTest.csv");
        reader = new InputReader(file);
        reader.read();
        parsedAdr = reader.getInputAddressList();
        parsedGroup = reader.getInputGroupList();
    }

    @Test
    public void testStringInputSize(){
        instantiate();
        assertEquals(2, parsedAdr.size());
        assertEquals(2, parsedGroup.size());
    }

    @Test
    public void testStringInputTextElvis(){
        instantiate();
        Address adr = parsedAdr.get(0);
        assertEquals("Elvis Presley", adr.getName());
        assertEquals("Elvis Presley Boulevard, Memphis, Tennessee 38116, USA", adr.getPhysical_address());
        assertEquals("012 345 67 89", adr.getPhone_number());
        assertEquals("elvis.presley@example.com", adr.getEmail());
    }

    @Test
    public void testStringInputTextRobert(){
        instantiate();
        Address adr = parsedAdr.get(1);
        assertEquals("Robert DeNiro", adr.getName());
        assertEquals("Bleecker Street, New York, NY, USA", adr.getPhysical_address());
        assertEquals("987 654 32 10", adr.getPhone_number());
        assertEquals("RobertDeNeiro@godfather.com", adr.getEmail());
    }

    @Test
    public void testStringInputTextGroup(){
        instantiate();
        Group group = parsedGroup.get(0);
        assertEquals("Famous people", group.getName());
        assertEquals(1, group.getNumber());
    }

    @Test
    public void testParseGroup(){
        instantiate();
        Group group = parsedGroup.get(1);
        int belongsTo = group.getGroups().get(0);
        assertEquals(belongsTo, 1);
    }

    @Test
    public void testParseGroupAddress(){
        instantiate();
        Address adr = parsedAdr.get(0);
        int belongsTo = adr.getGroups().get(0);
        assertEquals(belongsTo, 1);
    }

    @Test
    public void testGroupComposition(){
        instantiate();
        Group group = parsedGroup.get(0);
        Component child = group.getChildren().get(0);
        assertEquals(child, parsedGroup.get(1));
    }

    @Test
    public void testGroupCompositionRoot(){
        instantiate();
        Group root = reader.getRoot();
        assertEquals(1, root.getChildren().size());
        Component child = root.getChildren().get(0);
        assertEquals(child, parsedGroup.get(0));
    }

    @Test
    public void testAddressComposition(){
        instantiate();
        Group famous = parsedGroup.get(0);
        Address elvis = parsedAdr.get(0);
        assertEquals(elvis, famous.getChildren().get(1));
    }

}
