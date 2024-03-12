public class Ghost extends Character {

    private String color;
    private boolean inBase;

    public Ghost(boolean alive, String direction, String color, boolean inBase) {
        super(alive, direction);
        this.color = color;
        this.inBase = inBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        color = newColor;
    }

    public boolean isInBase() {
        return inBase;
    }

    public void setInBase(boolean baseStatus) {
        inBase = baseStatus;
    }

}
