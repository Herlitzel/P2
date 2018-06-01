import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class PrintTest {
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
    public void PrintTestEminem(){
        init();
        PrintVisitor v = new PrintVisitor();
        eminem.accept(v);
        assertEquals("Groups\n" +
                "\n" +
                "Addresses\n" +
                "\n" +
                "name: Eminem\n" +
                "Address: Music Street, New York, NY, USA\n" +
                "Phone: 039 393 3918 29\n" +
                "Email: eminem@RapGod.com\n" +
                "Groups: Famous people \n" +
                "\n", v.getPrintResults());
    }

    @Test
    public void PrintTestEminemAndElvis(){
        init();
        PrintVisitor v = new PrintVisitor();
        eminem.accept(v);
        elvis.accept(v);
        assertEquals("Groups\n" +
                "\n" +
                "Addresses\n" +
                "\n" +
                "name: Eminem\n" +
                "Address: Music Street, New York, NY, USA\n" +
                "Phone: 039 393 3918 29\n" +
                "Email: eminem@RapGod.com\n" +
                "Groups: Famous people \n" +
                "\n" +
                "name: Elvis Presley\n" +
                "Address: Elvis Presley Boulevard, Memphis, Tennessee 38116, USA\n" +
                "Phone: 012 345 67 89\n" +
                "Email: elvis.presley@example.com\n" +
                "Groups: Famous people \n" +
                "\n", v.getPrintResults());
    }

    @Test
    public void PrintTestGroupDead(){
        init();
        PrintVisitor v = new PrintVisitor();
        dead.accept(v);
        assertEquals("Groups\n" +
                "\n" +
                "Group: Dead people\n" +
                "Members: \n" +
                "-Freddie Mercury\n" +
                "-Michael Jackson\n" +
                "Addresses\n" +
                "\n", v.getPrintResults());
    }
}
