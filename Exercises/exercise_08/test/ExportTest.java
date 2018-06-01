import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;

public class ExportTest {

    private Group root;

    private Address spongebob,jackson,mercury,eminem,depp,dicaprio,deniro,elvis;
    private Group actors,famous,dead;

    private void init(){
        File file = new File("test/AddressBookExample.csv");
        InputReader reader = new InputReader(file);
        reader.read();
        this.root = reader.getRoot();

        spongebob = (Address)root.getChildren().get(2);
        famous = (Group)root.getChildren().get(0);
        dead = (Group)root.getChildren().get(1);

        actors = (Group)famous.getChildren().get(0);
        jackson = (Address)famous.getChildren().get(4);
        mercury = (Address)famous.getChildren().get(3);
        eminem = (Address)famous.getChildren().get(2);
        elvis = (Address)famous.getChildren().get(1);

        deniro = (Address)actors.getChildren().get(0);
        dicaprio = (Address)actors.getChildren().get(1);
        depp = (Address)actors.getChildren().get(2);



    }

    @Test
    public void exportTestEminem(){
        init();
        ExportVisitor v = new ExportVisitor();
        eminem.accept(v);
        assertEquals("Eminem;Music Street, New York, NY, USA;039 393 3918 29;eminem@RapGod.com;1,\n", v.getAddressString());
    }

    @Test
    public void exportTestEminemAndElvis(){
        init();
        ExportVisitor v = new ExportVisitor();
        eminem.accept(v);
        elvis.accept(v);
        assertEquals("Eminem;Music Street, New York, NY, USA;039 393 3918 29;eminem@RapGod.com;1,\nElvis Presley;Elvis Presley Boulevard, Memphis, Tennessee 38116, USA;012 345 67 89;elvis.presley@example.com;1,\n", v.getAddressString());
    }

    @Test
    public void exportTestGroupDead(){
        init();
        ExportVisitor v = new ExportVisitor();
        dead.accept(v);
        assertEquals("Dead people;3;\n", v.getGroupString());
    }
}
