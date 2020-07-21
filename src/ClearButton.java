/*
  Course: 		   CS300 - Summer 2020
  Program:		   Program 5 Jungle Park
  Name: 		   Wade Roberts
  Wisc Email: 	   wroberts5@wisc.edu
  Web Sources:     None
  Personal Help:   None
 */

public class ClearButton extends Button {

    public ClearButton(float x, float y, JunglePark park) {
        super(x, y, park);
        this.label = "Clear Park";
    }

    /**
     * Clears all of the animals from the screen when pressed.
     */
    @Override
    public void mousePressed() {
        park.clear();
    }
}
