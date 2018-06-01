import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * InputReader is used to read Address data input. It can be both format String or a CSV File.
 *
 * It is responsible for reading a text input, creating addresses and groups from it and
 * finally make a composite consisteing of these Components.
 *
 * It knows the list of all addresses and all groups. Furthermore, it provides a root group
 * where everything is attached to.
 *
 * @see Component
 */
public class InputReader {

    private Scanner inputStream;
    private LinkedList<Address> inputAddressList;
    private LinkedList<Group> inputGroupList;
    private Group root;

    private boolean invariant(){
        return (inputStream != null &&
                inputAddressList != null &&
                inputGroupList != null);
    }

    /**
     * Takes a .csv File and parses its Input to Address and Group objects.
     * It can read files with the following two line formats:
     *
     * Address:
     * Name;physical address;phone number;email address;groups
     *
     * Group:
     * Group name;group number;groups
     *
     * @param file          The Input file in csv format
     */
    public InputReader(File file){
        try {
            inputStream = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        instantiate();
        assert(invariant());
    }

    /**
     * Takes String and parses its Input to Address and Group objects.
     * It can read files with the following two line formats:
     *
     * Address:
     * Name;physical address;phone number;email address;groups
     *
     * Group:
     * Group name;group number;groups
     *
     * @param csv           The Input String formatted as csv
     */
    public InputReader(String csv){
        inputStream = new Scanner(csv);
        instantiate();
        assert(invariant());
    }

    /**
     * Used to instantiate Parameters
     */
    private void instantiate(){
        inputAddressList = new LinkedList<Address>();
        inputGroupList = new LinkedList<Group>();
        root = new Group("root", 0);
    }

    /**
     * Method that starts the Input parsing process.
     * It reads the text line by line and uses a regex Splitter ";" to seperate the attributes.
     *
     * At the end, it calls the compose method, that brings together the composition.
     */
    public void read(){
        assert(inputStream.hasNext());

        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            String[] fields = line.split(";");

            //If Line is address line
            if(fields.length >= 4){
                Address adr = new Address(fields[0], fields[1], fields[2], fields[3]);
                if(fields.length == 5){
                    parseGroups(fields[4], adr);
                }
                inputAddressList.add(adr);
            }

            //If Line is Group Line
            else if(fields.length <=3){
                Group group = new Group(fields[0], Integer.parseInt(fields[1]));
                if(fields.length == 3){
                    parseGroups(fields[2], group);
                }
                inputGroupList.add(group);
            }
        }
        compose();
        assert(invariant());
    }

    /**
     * Helper Method for read to parse groups.
     * @param field         groups string
     * @param comp          component that holds the groups listed in the string.
     */
    private void parseGroups(String field, Component comp) {
        assert(!field.isEmpty() && comp != null);

        Scanner groupStream = new Scanner(field);
        groupStream.useDelimiter(",");
        while(groupStream.hasNextInt()){
            comp.addGroup(groupStream.nextInt());
        }
    }

    /**
     * Creates a Composition containtig all the parsed groups and addresses.
     * Groups can contain addresses or other groups.
     * Composition is created out of the two parsed lists consisting of groups and addresses.
     *
     * This is done by adding the components to their respective upper components
     * --> by calling their addChild() method.
     *
     * @see Component
     */
    private void compose() {
        for(Group group : inputGroupList){
            if(group.getGroups().size() > 0){
                LinkedList<Integer> upperGroups = group.getGroups();
                for(int i = 0; i < upperGroups.size(); i++){
                    int id = upperGroups.get(i);
                    Group upper = findById(id);
                    upper.addChild(group);
                }
            } else{
                root.addChild(group);
            }
        }
        for(Address adr : inputAddressList){
            if(adr.getGroups().size() > 0){
                LinkedList<Integer> upperGroups = adr.getGroups();
                for(int i = 0; i < upperGroups.size(); i++){
                    int id = upperGroups.get(i);
                    Group upper = findById(id);
                    upper.addChild(adr);
                    adr.addParent(upper);
                }
            } else{
                root.addChild(adr);
            }
        }

        assert(root.getChildren().size() > 0);
    }

    /**
     * Helper Method to find group according to its ID number
     * @param id            The ID Number of the searched group
     * @return              The Group with the specified ID Number
     */
    private Group findById(int id){
        assert(inputGroupList.size() > 0);
        for(Group group : inputGroupList){
            if(group.getNumber() == id)
                return group;
        }
        return null;
    }

    /**
     * Returns the Root group.
     * @return          The root group.
     */
    public Group getRoot(){
        assert(root != null);
        return root;
    }

    /**
     * Returns the input address list (unsorted)
     * @return              The Input address list (unsorted)
     */
    public LinkedList<Address> getInputAddressList() {
        assert(invariant());
        return inputAddressList;
    }

    /**
     * Returns the Input group List (unsorted)
     * @return              The Input group list (unsorted)
     */
    public LinkedList<Group> getInputGroupList() {
        assert(invariant());
        return inputGroupList;
    }
}
