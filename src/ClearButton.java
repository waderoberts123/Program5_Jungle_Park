public class ClearButton extends Button {

    public ClearButton(float x, float y, JunglePark park) {
        super(x, y, park);
        this.label = "Clear Park";
    }

    @Override
    public void mousePressed() {
        park.clear();
    }
}
