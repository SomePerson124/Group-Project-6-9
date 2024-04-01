public class PacMan extends Character {
    private int moves;
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

    public void setSymbol() {
        if (getDirection().equals("north")) {super.setSymbol("V");}
        if (getDirection().equals("south")) {super.setSymbol("^");}
        if (getDirection().equals("west")) {super.setSymbol(">");}
        if (getDirection().equals("east")) {super.setSymbol("<");}
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

    public void move() {
        moves++;
    }

    public void death() {
        lives--;
    }


}
