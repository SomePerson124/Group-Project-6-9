import java.util.Scanner;
import java.util.ArrayList;

public class PacManLogic {
    private Scanner scan = new Scanner(System.in);
    private int rows;
    private int columns;
    private int pacManRow;
    private int pacManCol;
    private int ghostRow;
    private int ghostCol;
    private PacMan pacMan;
    private Ghost ghost;
    Spaces[][] maze;
    ArrayList<Integer> highScores;

    public PacManLogic() {
        rows = 10;
        columns = 26;
        pacManCol = 1;
        pacManRow = 1;
        ghostRow = 5;
        ghostCol = 10;
        highScores = new ArrayList<>();
        maze = new Spaces[rows][columns];
        pacMan = new PacMan("<", true, "east");
        ghost = new Ghost("👻", "east");
        start();
    }

    private void start() {
        setUpMaze();
        printMaze();
        game();
    }

    private void setUpMaze() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                maze[r][c] = new Pellet(".");
                if (r == 0 || r == maze.length - 1) {
                    maze[r][c] = new Wall("_");
                } else if (c == 0 || c == maze[r].length - 1) {
                    maze[r][c] = new Wall("|");
                }
            }
        }
        maze[pacManRow][pacManCol] = pacMan;
        maze[ghostRow][ghostCol] = ghost;
        maze[5][0] = new Warp("[");
        maze[5][columns - 1] = new Warp("]");
    }

    private void printMaze() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                System.out.print(maze[r][c].getSymbol());
            }
            System.out.println();
        }
    }

    public void game() {
        int random1 = (int) (Math.random() * 91 + 100);
        int random2 = (int) (Math.random() * 91 + 100);
        highScores.add(random1);
        highScores.add(random2);
        while (arePelletsLeft() && pacMan.isAlive()) {
            System.out.print("Enter W, A, S, D: ");
            String moveKey = scan.nextLine().toUpperCase();
            if (moveKey.equals("W")) {
                if (validMove(pacManRow - 1, pacManCol)) {
                    if (isGhost(pacManRow - 1, pacManCol)) {
                        maze[pacManRow][pacManCol] = new Spaces(" ");
                        pacMan.setAlive(false);
                    } else {
                        if (isPellet(pacManRow - 1, pacManCol)) {
                            pacMan.collectPellet();
                        }
                        maze[pacManRow - 1][pacManCol] = pacMan;
                        maze[pacManRow][pacManCol] = new Spaces(" ");
                        pacManRow = pacManRow - 1;
                    }
                }
                pacMan.setDirection("north");
            } else if (moveKey.equals("A")) {
                if (validMove(pacManRow, pacManCol - 1)) {
                    if (isGhost(pacManRow, pacManCol - 1)) {
                        maze[pacManRow][pacManCol] = new Spaces(" ");
                        pacMan.setAlive(false);
                    } else {
                        if (isWarp(pacManRow, pacManCol - 1)) {
                            maze[pacManRow][pacManCol] = new Spaces(" ");
                            pacManCol = maze[0].length - 2;
                            if (isPellet(pacManRow, pacManCol)) {
                                pacMan.collectPellet();
                            }
                            maze[pacManRow][pacManCol] = pacMan;
                            maze[5][maze[0].length - 1] = new Warp("]");
                        } else {
                            if (isPellet(pacManRow, pacManCol - 1)) {
                                pacMan.collectPellet();
                            }
                            maze[pacManRow][pacManCol - 1] = pacMan;
                            maze[pacManRow][pacManCol] = new Spaces(" ");
                            pacManCol = pacManCol - 1;
                        }
                    }
                }
                pacMan.setDirection("west");
            } else if (moveKey.equals("S")) {
                if (validMove(pacManRow + 1, pacManCol)) {
                    if (isGhost(pacManRow + 1, pacManCol)) {
                        maze[pacManRow][pacManCol] = new Spaces(" ");
                        pacMan.setAlive(false);
                    } else {
                        if (isPellet(pacManRow + 1, pacManCol)) {
                            pacMan.collectPellet();
                        }
                        maze[pacManRow + 1][pacManCol] = pacMan;
                        maze[pacManRow][pacManCol] = new Spaces(" ");
                        pacManRow = pacManRow + 1;
                    }
                }
                pacMan.setDirection("south");
            } else if (moveKey.equals("D")) {
                if (validMove(pacManRow, pacManCol + 1)) {
                    if (isGhost(pacManRow, pacManCol + 1)) {
                        maze[pacManRow][pacManCol] = new Spaces(" ");
                        pacMan.setAlive(false);
                    } else {
                        if (isWarp(pacManRow, pacManCol + 1)) {
                            maze[pacManRow][pacManCol] = new Spaces(" ");
                            pacManCol = 1;
                            if (isPellet(pacManRow, pacManCol)) {
                                pacMan.collectPellet();
                            }
                            maze[pacManRow][pacManCol] = pacMan;
                            maze[5][0] = new Warp("[");
                        } else {
                            if (isPellet(pacManRow, pacManCol + 1)) {
                                pacMan.collectPellet();
                            }
                            maze[pacManRow][pacManCol + 1] = pacMan;
                            maze[pacManRow][pacManCol] = new Spaces(" ");
                            pacManCol = pacManCol + 1;
                        }
                    }
                }
                pacMan.setDirection("east");
            } else {
                System.out.println("INVALID DIRECTION");
            }
            moveGhost();
            pacMan.setSymbol();
            printMaze();
        }
        System.out.println(scoresList(pacMan.getPelletsCollected()));
    }

    private boolean validMove(int row, int col) {
        if (!(maze[row][col] instanceof Wall)){
            return true;
        } else {
            System.out.println("Cannot move there!");
            return false;
        }
    }

    private void moveGhost() {
        String dir = ghost.direction();
        if (dir.equals("north")) {
            if (!(maze[ghostRow - 1][ghostCol] instanceof Wall)) {
                maze[ghostRow - 1][ghostCol] = ghost;
                maze[ghostRow][ghostCol] = new Spaces(" ");
                ghostRow--;
            }
        }
        if (dir.equals("west")) {
            if (!(maze[ghostRow][ghostCol - 1] instanceof Wall) && !(maze[ghostRow][ghostCol - 1] instanceof Warp)) {
                maze[ghostRow][ghostCol - 1] = ghost;
                maze[ghostRow][ghostCol] = new Spaces(" ");
                ghostCol--;
            }
        }
        if (dir.equals("south")) {
            if (!(maze[ghostRow + 1][ghostCol] instanceof Wall)) {
                maze[ghostRow + 1][ghostCol] = ghost;
                maze[ghostRow][ghostCol] = new Spaces(" ");
                ghostRow++;
            }
        }
        if (dir.equals("east")) {
            if (!(maze[ghostRow][ghostCol + 1] instanceof Wall) && !(maze[ghostRow][ghostCol + 1] instanceof Warp)) {
                maze[ghostRow][ghostCol + 1] = ghost;
                maze[ghostRow][ghostCol] = new Spaces(" ");
                ghostCol++;
            }
        }
        ghost.setDirection(dir);
        ghost.setSymbol();
    }

    private boolean isPellet(int row, int col) {
        if (maze[row][col] instanceof Pellet) {
            return true;
        }
        return false;
    }

    private boolean isWarp(int row, int col) {
        if (maze[row][col] instanceof Warp) {
            return true;
        }
        return false;
    }

    private boolean isGhost(int row, int col) {
        if (maze[row][col] instanceof Ghost) {
            return true;
        }
        return false;
    }

    private boolean arePelletsLeft() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                if (maze[r][c] instanceof Pellet) {
                    return true;
                }
            }
        }
        return false;
    }

    private String scoresList(int playerScore) {
        highScores.add(playerScore);
        int greatest = highScores.get(0);
        int least = highScores.get(0);
        int middle = 0;
        int idxPS = 0;
        String str = "";
        for (int i = 0; i < highScores.size(); i++) {
            if (highScores.get(i) > greatest) {
                greatest = highScores.get(i);
            }
            if (highScores.get(i) < least) {
                least = highScores.get(i);
            }
        }
        for (int i = 0; i < highScores.size(); i++) {
            if (highScores.get(i) != greatest && highScores.get(i) != least) {
                middle = highScores.get(i);
            }
        }
        for (int i = 0; i < highScores.size(); i++) {
            if (highScores.get(i) == playerScore) {
                idxPS = i;
            }
        }
        str += "High Scores:\n";
        str += "1. " + greatest + " pellets\n";
        str += "2. " + middle + " pellets\n";
        str += "3. " + least + " pellets\n";
        System.out.println("You placed #" + (idxPS + 1) + "!");
        return str;
    }

}