/**
 * TODO: File Header must go here
 */

import java.util.Random;

/**
 * This class represents an animal in the Jungle Park application
 *
 * @author Mouna Kacem, Andrew Kuemmel
 */
public abstract class Animal implements Displayable {

    private static final Random randGen = new Random(); // Generator of random numbers
    protected String label; // represents the animal's identifier
    // Fields defined to draw the animal in the application display window
    protected JunglePark park; // PApplet object that represents the display window
    protected PImage image; // animal's image

    private final float[] position; // animal's position in the display window
    // Usage: position[0: x-coordinate, or 1: y-coordinate]
    private boolean isDragging; // indicates whether the animal is being dragged or not


    /**
     * Creates a new Animal object positioned at a given position of the display window
     *
     * @param park          PApplet object that represents the display window
     * @param positionX     x-coordinate of the animal's image in the display window
     * @param positionY     y-coordinate of the animal's image in the display window
     * @param imageFileName filename of the animal image
     */
    public Animal(JunglePark park, float positionX, float positionY, String imageFileName) {

        // Set Animal drawing parameters
        this.park = park; // set the PApplet Object where the animal will be drawn
        this.position = new float[]{positionX, positionY}; // sets the position of the animal object
        this.image = park.loadImage(imageFileName);
        isDragging = false; // initially the animal is not dragging
    }

    /**
     * Creates a new Animal object positioned at a random position of the display window
     *
     * @param park          PApplet object that represents the display window
     * @param imageFileName filename of the animal image
     */
    public Animal(JunglePark park, String imageFileName) {
        this(park, (float) randGen.nextInt(park.width),
                Math.max((float) randGen.nextInt(park.height), 100), imageFileName);
    }

    /**
     * Draws the Animal to the display window. It sets also its position to the mouse position if the
     * Animal is being dragged (i.e. if its isDragging field is set to true).
     */
    @Override
    public void draw() {
        // if the Animal is dragging, set its position to the mouse position with respect to the display
        // window (park) dimension
        if (this.isDragging) {
            // mouse outside the screen
            if (this.park.mouseX < 0) {
                this.position[0] = 0;
            } else {
                this.position[0] = Math.min(this.park.mouseX, this.park.width);
            }

            // mouse outside the screen
            if (this.park.mouseY < 0) {
                this.position[1] = 0;
            } else {
                this.position[1] = Math.min(this.park.mouseY, this.park.height);
            }
        }

        // draw the Animal at its current position
        this.park.image(this.image, this.position[0], position[1]);

        // Call the action for a graphics object in each draw iteration
        this.action();

        displayLabel(); // displays the label atop this Animal

    }

    /**
     * display's the Animal's label on the park's window screen
     */
    private void displayLabel() {
        this.park.fill(0); // specify font color: black
        this.park.text(label, this.position[0], this.position[1] + this.image.height / 2 + 4);
    }

    /**
     * Checks if the mouse is over the this object
     *
     * @return true if the mouse is over the this object, false otherwise
     */
    @Override
    public boolean isMouseOver() {
        int animalWidth = image.width; // image width
        int animalHeight = image.height; // image height

        // checks if the mouse is over the Animal
        return park.mouseX > position[0] - animalWidth / 2
                && park.mouseX < position[0] + animalWidth / 2
                && park.mouseY > position[1] - animalHeight / 2
                && park.mouseY < position[1] + animalHeight / 2;
    }

    @Override
    public void mousePressed() {
        if (isMouseOver())
            isDragging = true;
    }

    @Override
    public void mouseReleased() {
        isDragging = false;
    }

    /**
     * @return the label that represents the Animal's identifier
     */
    public String getLabel() {
        return label;
    }


    /**
     * @return the image of type PImage of the Animal object
     */
    public PImage getImage() {
        return image;
    }


    /**
     * @return the X coordinate of the animal position
     */
    public float getPositionX() {
        return position[0];
    }

    /**
     * @return the Y coordinate of the animal position
     */
    public float getPositionY() {
        return position[1];
    }


    /**
     * @param position the XPosition to set
     */
    public void setPositionX(float position) {
        this.position[0] = position;
    }

    /**
     * @param position the YPosition to set
     */
    public void setPositionY(float position) {
        this.position[1] = position;
    }

    /**
     *
     * @param otherAnimal the other animal to compare the distance to
     * @param range the range that would be considered a close distance
     * @return True if the other animal is within the range of distance, else false.
     */
    public boolean isClose(Animal otherAnimal, int range) {
        return distance(otherAnimal) < range;
    }

    /**
     * @return true if the animal is being dragged, false otherwise
     */
    public boolean isDragging() {
        return isDragging;
    }

    /**
     * Computes the euclidean distance between the current animal and another one
     *
     * @param otherAnimal reference to another animal
     * @return distance between the current animal and otherAnimal
     */
    public double distance(Animal otherAnimal) {
        return Math.sqrt(Math.pow(this.getPositionX() - otherAnimal.getPositionX(), 2)
                + Math.pow(this.getPositionY() - otherAnimal.getPositionY(), 2));
    }

    /**
     * Defines the behavior of the current animal in the jungle park
     */
    public abstract void action();


}
