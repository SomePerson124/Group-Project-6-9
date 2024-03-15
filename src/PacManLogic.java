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
        for (int i = 0; i < 150; i++) {
            maze[0][i] = new Spaces("⬜");
            maze[maze.length - 1][i] = new Spaces("⬜");
        }
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = new Spaces("⬜");
            maze[i][maze[0].length - 1] = new Spaces("⬜");
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

    }

}