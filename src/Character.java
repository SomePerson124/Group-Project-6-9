public class Character extends Spaces {

    private boolean alive;
    private String direction;


    public Character(String symbol, boolean alive, String direction) {
        super(symbol);
        this.alive = alive;
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean isAlive) {
        alive = isAlive;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String newDirection) {
        direction = newDirection;
    }

    public void setSymbol() {
        if (getDirection().equals("north")) {
            setSymbol("up");
        }
        if (getDirection().equals("south")) {
            setSymbol("down");
        }
        if (getDirection().equals("west")) {
            setSymbol("left");
        }
        if (getDirection().equals("east")) {
            setSymbol("right");
        }
    }

}