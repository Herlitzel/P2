import java.io.File;
import java.util.Scanner;

/**
 * This is the main interface. It prints some helps to the console and allows the user to interact
 * with the Address Book. It contains basic functions as:
 *  -Searching for attributes
 *  -Printing search results
 *  -Exporting search results
 */
public class MainInterface {
    public Group root;
    public Search search;
    private final String MENU_STRING = "------------------------------------------------\n" +
                                        "  Type search (attribute):(name) for searching  \n"+
                                        "     Type print for pretty-printing results     \n"+
                                        "    Type export for exporting Results in csv    \n"+
                                        "------------------------------------------------\n";

    private boolean invariant(){
        return(root != null);
    }
    /**
     * Instantiates the Addressbook. It takes the file given in the FilePath and reads it in with an
     * input reader.
     */
    public MainInterface(String filepath){
        assert(filepath.length() > 0);
        File file = new File(filepath);
        InputReader reader = new InputReader(file);
        reader.read();
        this.root = reader.getRoot();

        assert(invariant());

        interactWithUser();
    }

    /**
     * Main Method. Basically creats a MainInterface. The File path has to be given here.
     * @param args
     */
    public static void main(String[] args){
        System.out.println("------------------------------------------------\n" +
                           "-------------WELCOME TO ADDRESS BOOK------------\n"+
                           "--------by Cedric Aebi and Nicolas Müller-------\n"+
                           "------------------------------------------------\n");
        new MainInterface("exercise_08/test/AddressBookExample.csv");
    }

    /**
     * Reads the user input and calls the corresponding methods.
     */
    private void interactWithUser(){
        String input;
        while(true){
            assert(invariant());
            System.out.println(MENU_STRING);
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            if(input.contains("search"))
                search(input);
            else if(input.contains("print"))
                print(input);
            else if(input.contains("export"))
                export(input);
        }
    }

    /**
     * Creates a new Search with the given input.
     * @param input             The input string containing the search attributes. They must be
     *                          in the format: attribute:"text"
     * @see Search
     */
    private void search(String input) {
        assert(invariant());
        System.out.println("Searching....");
        search = new Search(input);
        search.performSearch(root);
    }

    /**
     * Prints the addresses and groups from the search results.
     * @param input         does nothing here.
     */
    private void print(String input){
        assert(invariant());
        System.out.println("Printing....");
        PrintVisitor pv = new PrintVisitor();
        for(Group g : search.getGroupResults()){
            g.accept(pv);
        }
        for(Address adr : search.getAddressResults()){
            adr.accept(pv);
        }
        System.out.println(pv.getPrintResults());
    }

    /**
     * Exports the search results in csv format and prints them to the console.
     *
     * @param input         Does nothing here.
     */
    private void export(String input){
        assert(invariant());
        System.out.println("Exporting....");
        ExportVisitor ev = new ExportVisitor();
        for(Address adr : search.getAddressResults())
            adr.accept(ev);
        for(Group g : search.getGroupResults())
            g.accept(ev);
        System.out.println(ev.getAddressString() + ev.getGroupString());
    }
}
