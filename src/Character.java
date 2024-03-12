public class Character {

    private boolean alive;
    private String direction;


    public Character(boolean alive, String direction) {
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

    public void move(String direction) {

    }

}