import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SearchInputTester {

    @Test
    public void instantiateTest(){
        Search s = new Search("");
        assertEquals("", s.getAttributes()[0]);
        assertEquals(6, s.getAttributes().length);
    }

    @Test
    public void parseSearchInputTestName(){
        Search s = new Search("name:\"bill\"");
        assertEquals("bill",s.getAttributes()[0]);
    }

    @Test
    public void parseSearchInputTestAddress(){
        Search s = new Search("address:\"fuck my life 21\"");
        assertEquals("fuck my life 21",s.getAttributes()[1]);
    }

    @Test
    public void parseSearchInputTestPhone(){
        Search s = new Search("phone:\"0781528291\"");
        assertEquals("0781528291",s.getAttributes()[2]);
    }

    @Test
    public void parseSearchInputTestEmail(){
        Search s = new Search("email:\"nothing@donaldtrump.com\"");
        assertEquals("nothing@donaldtrump.com",s.getAttributes()[3]);
    }

    @Test
    public void parseSearchInputTestGroup(){
        Search s = new Search("group:\"1,3\"");
        assertEquals("1,3",s.getAttributes()[4]);
    }

    @Test
    public void parseSearchInputTestAny(){
        Search s = new Search("any:\"any shit comes here\"");
        assertEquals("any shit comes here",s.getAttributes()[5]);
    }

    @Test
    public void parseSearchMultipleAttributes(){
        Search s = new Search("name:\"johnny\"address:\"end of the world\"phone:\"0182922929\"");
        assertEquals("johnny",s.getAttributes()[0]);
        assertEquals("end of the world",s.getAttributes()[1]);
        assertEquals("0182922929",s.getAttributes()[2]);
    }
}
