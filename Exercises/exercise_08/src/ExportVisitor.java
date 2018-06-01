/**
 * This Visitor is used for exporting the search results in csv format.
 * It contains a gorup and an address string that are filled by being accepted by components.
 */
public class ExportVisitor implements Visitor{
    private String groupString = "";
    private String addressString = "";

    /**
     * Visits a group and collects its date used to export.
     * @param group         The group to be exported.
     */
    @Override
    public void visitGroup(Group group) {
        groupString += group.getName()+";"+group.getNumber()+";";
        for(int g : group.getGroups())
            groupString += g + ",";
        groupString += "\n";
        assert(groupString.length() > 0);
    }

    /**
     * Visits an address and collects its data used to export.
     * @param address       The Address to be exported
     */
    @Override
    public void visitAddress(Address address) {
        addressString += address.getName()+";"+address.getPhysical_address()+";"+address.getPhone_number()+";"
                +address.getEmail()+";";
        for(int g : address.getGroups())
            addressString += g + ",";
        addressString += "\n";
        assert(addressString.length() > 0);
    }

    /**
     * Returns a csv representations of all the groups visited. (string)
     * @return          a csv representations of all the Groups visited. (string)
     */
    public String getGroupString(){
        return this.groupString;
    }

    /**
     * Returns a csv representations of all the addresses visited. (string)
     * @return          a csv representations of all the addresses visited. (string)
     */
    public String getAddressString(){
        return this.addressString;
    }
}
