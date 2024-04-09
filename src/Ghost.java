public class Ghost extends Character {

    public Ghost(String symbol, String direction) {
        super(symbol, true, direction);
    }

    public String direction() {
        int num = (int) (Math.random() * 4 + 1);
        if (num == 1) {
            return "north";
        } else if (num == 2) {
            return "west";
        } else if (num == 3) {
            return "south";
        } else {
            return "east";
        }
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