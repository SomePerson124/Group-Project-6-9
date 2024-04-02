import java.util.Scanner;
public class PacManLogic {
    private Scanner scan = new Scanner(System.in);
    private int pacManRow;
    private int pacManCol;
    private PacMan pacMan;
    Spaces[][] maze;




    public PacManLogic() {
        maze = new Spaces[20][151];
        start();
    }

    private void start() {
        setUpMaze();
        printMaze();
    }

    private void setUpMaze() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                maze[r][c] = new Spaces("_");
            }
        }
        pacMan = new PacMan("<", true, "east");
        pacManCol = 1;
        pacManRow = 1;
        maze[pacManRow][pacManCol] = pacMan;
        for (int i = 0; i < 150; i++) {
            maze[0][i] = new Wall("\uD82F\uDCA1");
            maze[maze.length - 1][i] = new Wall("\uD82F\uDCA1");
        }
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = new Wall("\uD82F\uDCA1");
            maze[i][maze[0].length - 1] = new Wall("\uD82F\uDCA1");
        }

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
        //placeholder
        while (!(maze[0][150] instanceof PacMan)) {
            System.out.println("Enter W, A, S, D: ");
            String moveKey = scan.nextLine();
            if (moveKey.equals("W")) {
                if (validMove(pacManCol, pacManRow - 1)) {
                    maze[pacManRow - 1][pacManCol] = pacMan;
                    maze[pacManRow][pacManCol] = new Spaces("_");
                    pacManRow = pacManRow - 1;
                }
                pacMan.setDirection("north");
            } else if (moveKey.equals("A")) {
                if (validMove(pacManCol - 1, pacManRow)) {
                    maze[pacManRow][pacManCol - 1] = pacMan;
                    maze[pacManRow][pacManCol] = new Spaces("_");
                    pacManCol = pacManCol - 1;
                }
                pacMan.setDirection("west");
            } else if (moveKey.equals("S")) {
                if (validMove(pacManCol, pacManRow + 1)) {
                    maze[pacManRow + 1][pacManCol] = pacMan;
                    maze[pacManRow][pacManCol] = new Spaces("_");
                    pacManRow = pacManRow + 1;
                }
                pacMan.setDirection("south");
            } else if (moveKey.equals("D")) {
                if (validMove(pacManCol + 1, pacManRow)) {
                    maze[pacManRow][pacManCol + 1] = pacMan;
                    maze[pacManRow][pacManCol] = new Spaces("_");
                    pacManCol = pacManCol + 1;
                }
                pacMan.setDirection("east");
            } else {
                System.out.println("INVALID DIRECTION");
            }
            pacMan.setSymbol();
            printMaze();
        }
        System.out.println("You win!");
    }

    private boolean validMove(int x, int y) {
        if (/*y >= 0 && x >= 0 && y < maze.length && x < maze[0].length &&*/ !(maze[x][y] instanceof Wall)){
            return true;
        } else {
            System.out.println("Cannot move there!");
            return false;
        }
    }

}