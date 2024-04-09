public class Ghost extends Character {

    public Ghost(String symbol, String direction) {
        super(symbol, true, direction);
    }

    @Override
    public void setSymbol() {
        if (getDirection().equals("north")) {
            setSymbol("⬆️");
        }
        if (getDirection().equals("south")) {
            setSymbol("⬇️");
        }
        if (getDirection().equals("west")) {
            setSymbol("⬅️");
        }
        if (getDirection().equals("east")) {
            setSymbol("➡️");
        }
    }

}