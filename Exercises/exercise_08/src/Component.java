/**
 * This is the Interface that contains both addresses and groups. Both of them are components.
 * The Components All the components:
 *  -match a string list from the search class
 *  -accept a visitor
 *  -belong different groups (which are components themselves)
 *
 * So all the data is stored in a composition of components by the compose method from the InputReader.
 *
 * @see InputReader
 */
public interface Component {
    /**
     * Returns true, if the component matches the given String array.
     * @param attribute         String array containing Attributes to match:
     *                          0:Name 1:Address 2:Phone 3:Email 4:Groups 5:any
     * @return                  True, if this component matches the string array.
     */
    public boolean match(String[] attribute);

    /**
     * Accepts a visitor and invokes its respective method. Used for Print and Export.
     * @param visitor           The Visitor to accept.
     */
    public void accept(Visitor visitor);

    /**
     * Returns true if component is a group
     * @return          True, if component is group
     *                  False, otherwise
     */
    public boolean isGroup();

    /**
     * Returns true if the Component is an address.
     * @return          True, if this component is an address
     *                  false otherwise.
     */
    public boolean isAddress();

    /**
     * Returns the name of the component
     * @return          The name of the component.
     */
    public String getName();

    /**
     * Adds the Group ID to this component
     * @param i         The ID of the group corresponding to this component.
     */
    public void addGroup(int i);
}
