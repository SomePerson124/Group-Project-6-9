public class Ghost extends Character {

    private String color;
    private boolean inBase;

    public Ghost(String symbol, boolean alive, String direction, String color, boolean inBase) {
        super(symbol, alive, direction);
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

    @Override
    public void setDirection(String newDirection) {

    }

}