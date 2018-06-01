import java.util.LinkedList;

/**
 * This Iterator takes a root group and lays out all its component in lists:
 * One for addresses and one for groups.
 * This class is mainly used by the search class and his algorithm.
 */
public class AddressBookIterator implements Iterator{
    private LinkedList<Group> groupList;
    private LinkedList<Address> addressList;

    private boolean invariant(){
        return(groupList != null && addressList!= null);
    }

    /**
     * Creates a new Iterator under the given group.
     * @param group
     */
    public AddressBookIterator(Group group){
        groupList = new LinkedList<Group>();
        addressList = new LinkedList<Address>();
        fillLists(group);
        assert(invariant());
    }

    /**
     * Helper Method called by the constructer. Fills the group and address lists.
     * @param group         The Group it has to lay out.
     */
    private void fillLists(Group group) {
        assert(group != null);
        for(Component c: group.getChildren()){
            if(c.isAddress() && !addressList.contains(c))
                addressList.add((Address)c);
            else if(c.isGroup()) {
                groupList.add((Group) c);
                fillLists((Group) c);
            }
        }
        assert(invariant());
    }

    /**
     * Gets the List of groups that lay under the specified one.
     * @return              The List of groups that lay under the specified one.
     */
    @Override
    public LinkedList<Group> getGroupList() {
        return groupList;
    }

    /**
     * Gets the List of Addresses that lay under the specified one.
     * @return              The List of Addresses that lay under the specified one.s
     */
    @Override
    public LinkedList<Address> getAddressList() {
        return addressList;
    }

}
