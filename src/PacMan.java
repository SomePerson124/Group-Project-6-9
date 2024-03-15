public class PacMan extends Character {

    private int pelletsCollected;
    private int points;
    private int lives;

    public PacMan(String symbol, boolean alive, String direction) {
        super(symbol, alive, direction);
        this.pelletsCollected = 0;
        this.points = 0;
        this.lives = 3;
    }

    public int getPelletsCollected() {
        return pelletsCollected;
    }

    public int getPoints() {
        return points;
    }

    public int getLives() {
        return lives;
    }

    public void collectPellet() {
        pelletsCollected++;
    }

    public void calculatePoints() {
        // implement code
    }

    public void death() {
        lives--;
    }

}
