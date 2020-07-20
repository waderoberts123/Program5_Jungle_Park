/**
 * File Header comes here
 */


public class Tiger extends Animal {
    private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for food
    private static final String IMAGE_FILE_NAME = "images/tiger.png";
    private static int nextID = 1; // class variable that represents the identifier of the next tiger
    // to be created
    // Tiger's identification fields
    private static final String TYPE = "TGR"; // A String that represents the tiger type
    private final int id; // Tiger's id: positive number that represents the order of the tiger


    /**
     * Creates a new Tiger object positioned at a random position of the display window
     *
     * @param processing PApplet object that represents the display window
     */
    public Tiger(JunglePark park) {
        // Set Tiger drawing parameters
        super(park, IMAGE_FILE_NAME);

        // Set Tiger identification fields
        id = nextID;
        this.label = TYPE + id; // String that identifies the current tiger
        nextID++;
    }


    /**
     * Tiger's behavior in the Jungle Park
     * Scans for food at the neighborhood of the current tiger.
     * If the Tiger founds any Deer at its proximity, it hops on it, and eats it
     */
    @Override
    public void action() {
        //TODO
    }


}
