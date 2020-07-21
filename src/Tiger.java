import java.util.Objects;

/**
 * File Header comes here
 */


public class Tiger extends Animal {
    private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for food
    private int deerEatenCount; // Number of deer the current tiger has eaten
    private static final String IMAGE_FILE_NAME = "images/tiger.png";
    private static int nextID = 1; // class variable that represents the identifier of the next tiger to be created
    // Tiger's identification fields
    private static final String TYPE = "TGR"; // A String that represents the tiger type
    private final int id; // Tiger's id: positive number that represents the order of the tiger

    /**
     * Creates a new Tiger object positioned at a random position of the display window
     *
     * @param park the JunglePark object
     */
    public Tiger(JunglePark park) {
        // Set Tiger drawing parameters
        super(park, IMAGE_FILE_NAME);

        // Set Tiger identification fields
        deerEatenCount = 0;
        id = nextID;
        this.label = TYPE + id; // String that identifies the current tiger
        nextID++;
    }

    /**
     * This method causes the Tiger object to go a nearby deer's location and eat it
     * @param food the deer that the lion will eat
     */
    public void hop(Deer food) {
        // Allows tiger to change position
        this.mouseReleased();

        // Move the location to the location of the Deer
        this.setPositionX(food.getPositionX());
        this.setPositionY(food.getPositionY());

        park.listGUI.remove(food); // Remove the object from the graphics object array
        deerEatenCount++;
    }

    /**
     * Tiger's behavior in the Jungle Park
     * Scans for food at the neighborhood of the current tiger.
     * If the Tiger founds any Deer at its proximity, it hops on it, and eats it
     */
    @Override
    public void action() {
        Deer deerToEat = null;

        for (Displayable graphicsObject : park.listGUI) {
            if (graphicsObject instanceof Deer) {
                Deer deer = (Deer) graphicsObject;
                if (isClose(deer, SCAN_RANGE)) {
                    deerToEat = deer;
                    break;
                }
            }
        }

        if (deerToEat != null) {
            hop(deerToEat);
        }

        if (deerEatenCount > 0) {
            displayDeerEatenCount(); // display deerEatenCount
        }
    }

    /**
     * Displays the number of deer eaten if any on the top of the tiger image
     */
    private void displayDeerEatenCount() {
        this.park.fill(0); // Specify font color to be black
        this.park.text(deerEatenCount, this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);
    }


}
