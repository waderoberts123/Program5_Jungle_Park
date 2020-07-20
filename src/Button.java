// This is abstract class for any Button that can be added to a PApplet application
// TODO: ADD File header, Javadoc method header to every method, and in-line commenting

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

    @Override
    public void mousePressed() {
        if (isMouseOver())
            System.out.println("A button was pressed.");
    }

    @Override
    public void mouseReleased() {
// nothing to do….buttons don't get dragged
    }

    @Override
    public boolean isMouseOver() {
        if (this.park.mouseX > this.position[0] - WIDTH / 2
                && this.park.mouseX < this.position[0] + WIDTH / 2
                && this.park.mouseY > this.position[1] - HEIGHT / 2
                && this.park.mouseY < this.position[1] + HEIGHT / 2)
            return true;
        return false;
    }
}
