import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;


public class AddressBookIteratorTest {
    private Group root;

    private void init(){
        File file = new File("test/AddressBookExample.csv");
        InputReader reader = new InputReader(file);
        reader.read();
        root = reader.getRoot();
    }

    @Test
    public void testIteratorAddress(){
        init();
        AddressBookIterator it = new AddressBookIterator(root);
        assertEquals(10, it.getAddressList().size());
    }

    @Test
    public void testIteratorGroups(){
        init();
        AddressBookIterator it = new AddressBookIterator(root);
        assertEquals(3, it.getGroupList().size());
    }
}
