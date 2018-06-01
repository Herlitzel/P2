import java.util.LinkedList;

/**
 * Represents an Address from the address book.
 * It knows:
 * -its Name
 * -its Physical address
 * -its phone number
 * -its email
 * -the ids of the groups it belongs to
 * -Its parent groups in a linked list
 *
 * It inherits from the component class and provides a function to match a given attribute in a string list.
 * It self is stored in a composition of components, which is being made from the inputReader class.
 */
public class Address implements Component {
    private String name;
    private String physical_address;
    private String phone_number;
    private String email;
    private String groupString = "";
    private LinkedList<Integer> groups;
    private LinkedList<Group> parents;

    private boolean invariant(){
        String[] empty = new String[]{"","","","","",""};
        return (this.match(empty));
    }
    /**
     * Creates an Address with the given parameters:
     *
     * @param name                  Name of the person
     * @param physical_address      Physical Address
     * @param phone_number          Phone number
     * @param email                 Email
     */
    public Address(String name, String physical_address, String phone_number, String email){
        this.name = name;
        this.physical_address = physical_address;
        this.phone_number = phone_number;
        this.email = email;
        groups = new LinkedList<Integer>();
        parents = new LinkedList<Group>();
        assert(invariant());
    }

    /**
     * Adds this addres to the group g. This is used by the compose method while the composition is being made.
     * @param g
     */
    public void addParent(Group g){
        assert(g != null);
        parents.add(g);
        groupString += g.getName() + " ";
        assert(invariant());
    }

    /**
     * Adds the Group ID to its list. Used while creating the composition.
     * @param group         The Group ID this address belongs to.
     */
    @Override
    public void addGroup(int group){
        this.groups.add(group);
        assert(invariant());
    }

    /**
     * Matches given String attributes. Returns true, if the address contains the specified attribute.
     * This is mainly used by the search method.
     *
     * @param attribute         String array of attributes (name,address,phone,email,group,any)
     * @return                  True, if every attribute matches. (matches also if empty)
     */
    @Override
    public boolean match(String[] attribute) {
        assert(attribute.length == 6);
        String any = name+physical_address+phone_number+email+groupString;

        return( name.toLowerCase().contains(attribute[0].toLowerCase()) &&
                physical_address.toLowerCase().contains(attribute[1].toLowerCase())&&
                phone_number.toLowerCase().contains(attribute[2].toLowerCase())&&
                email.toLowerCase().contains(attribute[3].toLowerCase())&&
                groupString.toLowerCase().contains(attribute[4].toLowerCase())&&
                any.toLowerCase().contains(attribute[5].toLowerCase()));
    }

    /**
     * Accepts a visitor and invokes its correct method.
     * Used for export and print visitors. They collect the data and store them in a string.
     *
     * @param visitor           The visitor to accept
     *
     * @see Visitor
     */
    @Override
    public void accept(Visitor visitor) {
        assert(visitor != null);
        visitor.visitAddress(this);
        assert(invariant());
    }

    /**
     * Returns true, if it is a group
     * @return          false in this case
     */
    @Override
    public boolean isGroup(){
        return false;
    }

    /**
     * Returns true, if this component is an address.
     * @return          true in this case
     */
    @Override
    public boolean isAddress(){
        return true;
    }

    /**
     * Returns the name stored in this address.
     * @return          The Name stored in this address.
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the Physical address stored in this address class.
     * @return          The Physical address stored in this address class.
     */
    public String getPhysical_address() {
        return physical_address;
    }

    /**
     * Gets the Phone number stored in this address.
     * @return          The Phone number stored in this address.
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Returns the Email stored in this address.
     * @return          The email stored in this address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the Groups this address belongs to (represented in a string by their group names)
     * @return              the Groups this address belongs to (represented in a string by their group names)
     */
    public String getGroupString(){return this.groupString;}

    /**
     * Returns an integer list of groups belonging to this address.
     * @return          The IDs of the groups this address belongs to.
     */
    public LinkedList<Integer> getGroups() {
        return groups;
    }
}
