/*
  Course: 		   CS300 - Summer 2020
  Program:		   Program 5 Jungle Park
  Name: 		   Wade Roberts
  Wisc Email: 	   wroberts5@wisc.edu
  Web Sources:     None
  Personal Help:   None
 */

public class Deer extends Animal {

    private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the neighborhood
    private static final String IMAGE_FILE_NAME = "images/deer.png";
    private static int nextID = 1; // class variable that represents the identifier of the next deer to be created

    private static final String TYPE = "DR"; // A String that represents the deer type
    private final int id; // Deer's id: positive number that represents the order of the deer

    // Constructor that creates a new Deer object positioned at a random position of the display window
    public Deer(JunglePark park) {
        super(park, IMAGE_FILE_NAME);
        this.id = nextID;
        this.label = TYPE + id;

        nextID++; // Increment the ID field each time a Deer object is created
    }

    /**
     * Checks if there is a threat (a Tiger for instance) at the neighborhood
     * @param scanRange represents the range of the area to be scanned around the animal
     * @return true if a threat (tiger) is near the deer
     */
    public boolean scanForThreat(int scanRange) {
        for (Displayable graphicsObject : park.listGUI) {
            if (graphicsObject instanceof Tiger) {
                Tiger tiger = (Tiger) graphicsObject;
                if (isClose(tiger, scanRange)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Defines the behavior of a Deer object in the Jungle park
     */
    @Override
    public void action() {
        if (scanForThreat(SCAN_RANGE)) {
            this.park.fill(0); // specify font color: black
            this.park.text("THREAT!", this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);
        }
    }

}
