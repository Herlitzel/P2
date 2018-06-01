import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;

public class SearchTest {

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
    public void initTest(){
        init();
        assertEquals(3, root.getChildren().size());

        assertEquals("Famous people", famous.getName());
        assertEquals("Dead people", dead.getName());
        assertEquals("Actors", actors.getName());

        assertEquals("Spongebob", spongebob.getName());
        assertEquals("Michael Jackson", jackson.getName());
        assertEquals("Freddie Mercury", mercury.getName());
        assertEquals("Eminem", eminem.getName());
        assertEquals("Elvis Presley", elvis.getName());

        assertEquals("Robert DeNiro", deniro.getName());
        assertEquals("Leonardo DiCaprio", dicaprio.getName());
        assertEquals("Johnny Depp", depp.getName());

    }

    @Test
    public void searchRobertTest(){
        init();
        Search s = new Search("name:\"robert\"");
        s.performSearch(root);
        assertEquals(1,s.getAddressResults().size());
        assertEquals(deniro, s.getAddressResults().get(0));
    }

    @Test
    public void searchActorsTest(){
        init();
        Search s = new Search("group:\"actor\"");
        s.performSearch(root);
        assertEquals(1,s.getGroupResults().size());
        assertEquals(actors, s.getGroupResults().get(0));
    }

    @Test
    public void searchSeveralAttributesTest(){
        init();
        Search s = new Search("group:\"actor\" name:\"johnny\"");
        s.performSearch(root);
        assertEquals(0,s.getGroupResults().size());
        assertEquals(1, s.getAddressResults().size());
        assertEquals(depp,s.getAddressResults().get(0));
    }

    @Test
    public void searchAnyTest(){
        init();
        Search s = new Search("any:\"usa\"");
        s.performSearch(root);
        assertEquals(0,s.getGroupResults().size());
        assertEquals(8, s.getAddressResults().size());
    }

    @Test
    public void searchNothingTest(){
        init();
        Search s = new Search("");
        s.performSearch(root);
        assertEquals(3,s.getGroupResults().size());
        assertEquals(10, s.getAddressResults().size());
    }
}
