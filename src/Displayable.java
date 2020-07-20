// No comments or file header needed.
// Note:  When adding this file in Eclipse, be sure to select New….Interface
// NO CODE SHOULD BE ADDED TO THIS FILE

public interface Displayable {
    public void draw(); // draws a Displayable object (Animal or Button) to the display window

    public void mousePressed(); // called each time the mouse is Pressed

    public void mouseReleased(); // called each time the mouse is released

    public boolean isMouseOver(); // checks whether the mouse is over this object

}
