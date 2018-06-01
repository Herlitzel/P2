/**
 * The Visitor interface is used for printing and exporting data: A Visitor can be accepted by a component
 * and and this one calls then the corresponding method.
 * A Visitor can visit components, so either a group or an address.
 *
 * @see ExportVisitor
 * @see PrintVisitor
 */
public interface Visitor {
    /**
     * Used to visit a group
     * @param group         The Group to visit.
     */
    public void visitGroup(Group group);

    /**
     * Used to visit an address
     * @param address           The Address to visit.
     */
    public void visitAddress(Address address);
}
