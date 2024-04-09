import java.util.Scanner;
public class PacManLogic {
    private Scanner scan = new Scanner(System.in);
    private int rows;
    private int columns;
    private int pacManRow;
    private int pacManCol;
    private PacMan pacMan;
    private Ghost ghost1;
    Spaces[][] maze;

    public PacManLogic() {
        rows = 10;
        columns = 26;
        pacManCol = 1;
        pacManRow = 1;
        maze = new Spaces[rows][columns];
        pacMan = new PacMan("<", true, "east");
        ghost1 = new Ghost("👻", true, "east");
        start();
    }

    private void start() {
        setUpMaze();
        printMaze();
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
        maze[5][10] = ghost1;
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
        while (arePelletsLeft()) {
            System.out.print("Enter W, A, S, D: ");
            String moveKey = scan.nextLine().toUpperCase();
            if (moveKey.equals("W")) {
                if (validMove(pacManRow - 1, pacManCol)) {
                    if (isPellet(pacManRow - 1, pacManCol)) {
                        pacMan.collectPellet();
                    }
                    maze[pacManRow - 1][pacManCol] = pacMan;
                    maze[pacManRow][pacManCol] = new Spaces(" ");
                    pacManRow = pacManRow - 1;
                }
                pacMan.setDirection("north");
            } else if (moveKey.equals("A")) {
                if (validMove(pacManRow, pacManCol - 1)) {
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
                pacMan.setDirection("west");
            } else if (moveKey.equals("S")) {
                if (validMove(pacManRow + 1, pacManCol)) {
                    if (isPellet(pacManRow + 1, pacManCol)) {
                        pacMan.collectPellet();
                    }
                    maze[pacManRow + 1][pacManCol] = pacMan;
                    maze[pacManRow][pacManCol] = new Spaces(" ");
                    pacManRow = pacManRow + 1;
                }
                pacMan.setDirection("south");
            } else if (moveKey.equals("D")) {
                if (validMove(pacManRow, pacManCol + 1)) {
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
                pacMan.setDirection("east");
            } else {
                System.out.println("INVALID DIRECTION");
            }
            pacMan.setSymbol();
            printMaze();
        }
        System.out.println("You win!");
        System.out.println(pacMan.getPelletsCollected());
    }

    private boolean validMove(int row, int col) {
        if (!(maze[row][col] instanceof Wall)){
            return true;
        } else {
            System.out.println("Cannot move there!");
            return false;
        }
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

}