public class PacMan extends Character {

    private int pelletsCollected;
    private int points;
    private int lives;

    public PacMan(boolean alive, String direction, int pelletsCollected, int points, int lives) {
        super(alive, direction);
        this.pelletsCollected = pelletsCollected;
        this.points = points;
        this.lives = lives;
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
