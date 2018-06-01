/**
 * This Visitor is used for printing the components nicely in a string.
 * It contains a gorup and an address string that are filled by being accepted by components.
 */
public class PrintVisitor implements Visitor{
    private String printGroups = "Groups\n\n";
    private String printAddress = "Addresses\n\n";

    private boolean invariant(){
        return(printGroups.length() > 0 && printAddress.length() > 0);
    }

    /**
     * Visits a group and collects its date used to print.
     * @param group         The group to be printed.
     */
    @Override
    public void visitGroup(Group group) {
        assert(group != null);
        printGroups += "Group: " + group.getName() + "\n" +
                       "Members: \n";
                        for(Component c : group.getChildren()){
                            printGroups += "-" + c.getName() + "\n";
                        }
                        assert(invariant());
    }

    /**
     * Visits an address and collects its data used to print.
     * @param address       The Address to be printed
     */
    @Override
    public void visitAddress(Address address) {
        assert(address != null);
        printAddress += "name: " +    address.getName() + "\n" +
                        "Address: " + address.getPhysical_address() + "\n" +
                        "Phone: " +   address.getPhone_number() + "\n" +
                        "Email: " +   address.getEmail() + "\n" +
                        "Groups: "+   address.getGroupString() + "\n\n";
        assert(invariant());
    }

    /**
     * Returns the string with the printed components. The Resulting String.
     * @return              The resulting String representing the components.
     */
    public String getPrintResults(){
        return printGroups + printAddress;
    }
}
