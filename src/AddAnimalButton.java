public class AddAnimalButton extends Button {

    private String type;

    public AddAnimalButton(String type, float x, float y, JunglePark park) {
        super(x, y, park);
        this.type = type.toLowerCase();
        this.label = "Add " + type;
    }

    @Override
    public void mousePressed() {
        if (isMouseOver()) {
            switch (type) {
                case "tiger":
                    park.listGUI.add(new Tiger(park));
                    break;
                case "deer":
                    park.listGUI.add(new Deer(park));
                    break;
            }
        }
    }
}
