import java.util.LinkedList;

/**
 * A Group is a component. It can contain other groups and addresses.
 * The gorup knows its name and its group number (which should only exist once in the book.)
 * It also has a list of Children, which contains all components this group contains.
 */
public class Group implements Component {
    private String groupName;
    private int groupNumber;
    private LinkedList<Integer> groups;
    private LinkedList<Component> children;

    private boolean invariant(){
        String[] empty = new String[]{"","","","","",""};
        return (this.match(empty));
    }

    /**
     * Creates a group with the given Name and number.
     * @param groupName             The Name of this group
     * @param groupNumber           The Number of this group.
     */
    public Group(String groupName, int groupNumber){
        children = new LinkedList<Component>();
        groups = new LinkedList<Integer>();
        this.groupName = groupName;
        this.groupNumber = groupNumber;
        assert(invariant());
    }

    /**
     * Add a child to this group. Adds the given component to its children list.
     * @param component             The component to add as a child here.
     */
    public void addChild(Component component){
        children.add(component);
        assert(invariant());
    }

    /**
     * Returns all the children (components) of this group as a linked list.
     * @return              All the children (components) of this group as a linked list.
     */
    public LinkedList<Component> getChildren(){
        return this.children;
    }

    /**
     * Adds a group to this group with its number.
     * @param groupNumber           An int that is the group number to add.
     */
    @Override
    public void addGroup(int groupNumber) {
        this.groups.add(groupNumber);
        assert(invariant());
    }

    /**
     * Used to match a given search input. This is called by the search class. It returns
     * true, if the group contains any of the attributes given.
     *
     * @param attribute         String array containing Attributes to match:
     *                          0:Name 1:Address 2:Phone 3:Email 4:Groups 5:any
     * @return                  true, if the group contains any of the attributes given.
     *                          else otherwise.
     */
    @Override
    public boolean match(String[] attribute) {
        assert(attribute.length == 6);
        return (groupName.toLowerCase().contains(attribute[4].toLowerCase()) &&
                groupName.toLowerCase().contains(attribute[5].toLowerCase()));
    }

    /**
     * Accepts a visitor and calls its corresponding method. Used by the printer and exporter.
     * @param visitor           The Visitor to accept.
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitGroup(this);
        assert(invariant());
    }

    /**
     * Returns true, because this is a group.
     * @return              true, because this is a group.
     */
    @Override
    public boolean isGroup(){
        return true;
    }

    /**
     * Returns false, because this is a group.
     * @return          false, because this is a group.
     */
    @Override
    public boolean isAddress(){
        return false;
    }

    /**
     * Returns a string of the name from this group.
     * @return              The Name of this group.
     */
    public String getName() {
        return groupName;
    }

    /**
     * Returns this groups number.
     * @return          This groups number.
     */
    public int getNumber() {
        return groupNumber;
    }

    /**
     * Returns a linked list of integers containing the groups it belongs to.
     * @return              a linked list of integers containing the groups it belongs to.
     */
    public LinkedList<Integer> getGroups() {
        return groups;
    }
}
