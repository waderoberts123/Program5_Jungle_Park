/*
  Course: 		   CS300 - Summer 2020
  Program:		   Program 5 Jungle Park
  Name: 		   Wade Roberts
  Wisc Email: 	   wroberts5@wisc.edu
  Web Sources:     None
  Personal Help:   None
 */

// This is abstract class for any Button that can be added to a PApplet application

public abstract class Button implements Displayable {
    private static final int WIDTH = 85; // Width of the Button
    private static final int HEIGHT = 32; // Height of the Button
    protected JunglePark park; // PApplet object where the button will be displayed
    private float[] position; // array storing x and y positions of the Button with respect to
    // the display window
    protected String label;   // text/label that represents the button

    public Button(float x, float y, JunglePark park) {
        this.park = park;
        this.position = new float[2];
        this.position[0] = x;
        this.position[1] = y;
        this.label = "Button";
    }

    /**
     * Defines how a button is drawn on the screen
     */
    @Override
    public void draw() {
        this.park.stroke(0);// set line value to black
        if (isMouseOver())
            park.fill(100); // set the fill color to dark gray if the mouse is over the button
        else
            park.fill(200); // set the fill color to light gray otherwise

        // draw the button (rectangle with a centered text)
        park.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
                position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
        park.fill(0); // set the fill color to black
        park.text(label, position[0], position[1]); // display the text of the current button
    }

    /**
     * If the mouse is over the button and pressed, defines the default behavior.
     */
    @Override
    public void mousePressed() {
        if (isMouseOver())
            System.out.println("A button was pressed.");
    }

    /**
     * Defines what to do when the mouse is released
     */
    @Override
    public void mouseReleased() {}

    /**
     * Defines how to tell when the mouse is over the object
     * @return true if the mouse is on the object, else false
     */
    @Override
    public boolean isMouseOver() {
        return this.park.mouseX > this.position[0] - WIDTH / 2
                && this.park.mouseX < this.position[0] + WIDTH / 2
                && this.park.mouseY > this.position[1] - HEIGHT / 2
                && this.park.mouseY < this.position[1] + HEIGHT / 2;
    }
}
