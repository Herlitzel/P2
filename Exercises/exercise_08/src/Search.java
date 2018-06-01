import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Search class is responsible for searching through the address-group composition. It takes
 * some Attributes and looks for matches.
 * It uses an iterator and fills its results to linked lists.
 * It is called by the MainInterface class.
 */
public class Search {
    private LinkedList<Group> groupResults;
    private LinkedList<Address> addressResults;
    private String[] attributes;

    /**
     * Class Invariant of the search class.
     * @return
     */
    private boolean invariant(){
        return (attributes.length == 6);
    }

    /**
     * Instantiates a new search with the given input string.
     * @param searchString          The String containing the attributes used to search.
     */
    public Search(String searchString){
        attributes = new String[]{"","","","","",""};
        groupResults = new LinkedList<Group>();
        addressResults = new LinkedList<Address>();
        parseAttributes(searchString);
        assert(invariant());
    }

    /**
     * Has to be called in order to perform a search. It searches through all the components under
     * the given group.
     *
     * @param group             The Group in which to search through the components.
     */
    public void performSearch(Group group){
        AddressBookIterator iterator = new AddressBookIterator(group);

        //Find Address Matches
        for(Address adr : iterator.getAddressList()){
            if(adr.match(attributes))
                addressResults.add(adr);
        }

        //Check if it is a group search
        if(!isGroupSearch())
            return;

        //Else Find Group Matches
        for(Group g : iterator.getGroupList()){
            if(g.match(attributes)){
                groupResults.add(g);
            }
        }
    }

    /**
     * Helper Method to search.
     * @return          true, if it is a gorup search.
     */
    private boolean isGroupSearch() {
        return (attributes[0].length() == 0 &&
                attributes[1].length() == 0 &&
                attributes[2].length() == 0 &&
                attributes[3].length() == 0);
    }

    /**
     * Helper method used to parse search attributes
     * @param searchString          String that contains the attributes.
     */
    private void parseAttributes(String searchString) {
        findAttribute(searchString, "name", 0);
        findAttribute(searchString, "address", 1);
        findAttribute(searchString, "phone", 2);
        findAttribute(searchString, "email", 3);
        findAttribute(searchString, "group", 4);
        findAttribute(searchString, "any", 5);
    }

    /**
     * Helper Method to parse Attributes.
     * @param searchString          The string containing the search attributes
     * @param atr                   The attribute name
     * @param index                 The index of the attribute
     */
    private void findAttribute(String searchString, String atr, int index) {
        String patternText = "(?<=" + atr + ":)\"([^\"]*)\"";
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(searchString);
        if(matcher.find()){
            attributes[index] = matcher.group(1);
        }
    }

    /**
     * Returns the parsed search attributes.
     * @return          the parsed search attributes.
     */
    public String[] getAttributes(){
        return this.attributes;
    }

    /**
     * Returns the resulting groups from the search.
     * @return          The groups that matched the search.
     */
    public LinkedList<Group> getGroupResults() {
        return groupResults;
    }

    /**
     * Returns the resulting addresses from the search.
     * @return          The addresses that matched the search.
     */
    public LinkedList<Address> getAddressResults() {
        return addressResults;
    }
}
