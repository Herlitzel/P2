import java.util.LinkedList;

public interface Iterator {

    /**
     * Gets the List of groups that lay under the specified one.
     * @return              The List of groups that lay under the specified one.
     */
    public LinkedList<Group> getGroupList();

    /**
     * Gets the List of Addresses that lay under the specified one.
     * @return              The List of Addresses that lay under the specified one.s
     */
    public LinkedList<Address> getAddressList();
}
