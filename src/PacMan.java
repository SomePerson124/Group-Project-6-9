public class PacMan extends Character {
    private int pelletsCollected;

    public PacMan(String symbol, boolean alive, String direction) {
        super(symbol, alive, direction);
        this.pelletsCollected = 0;
    }

    public int getPelletsCollected() {
        return pelletsCollected;
    }

    public void setSymbol() {
        if (getDirection().equals("north")) {
            setSymbol("V");
        }
        if (getDirection().equals("south")) {
            setSymbol("^");
        }
        if (getDirection().equals("west")) {
            setSymbol(">");
        }
        if (getDirection().equals("east")) {
            setSymbol("<");
        }
    }

    public void collectPellet() {
        pelletsCollected++;
    }

}
