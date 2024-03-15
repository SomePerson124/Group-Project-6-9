public class PacManLogic {

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
        maze[19][150] = new PacMan("C", true, "right");
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

    }

}