public class PacManLogic {

    Spaces[][] maze;


    public PacManLogic() {
        maze = new Spaces[20][151];
        start();
    }

    private void start() {
        setUpMaze();
        printGrid();
    }

    private void setUpMaze() {
        for (int i = 0; i < 150; i++) {
            maze[0][i] = new Spaces("⬜");
            maze[maze.length - 1][i] = new Spaces("⬜");
        }
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = new Spaces("⬜");
            maze[i][maze[0].length - 1] = new Spaces("⬜");
        }
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                if (maze[r][c] == null) {
                    maze[r][c] = new Spaces("-");
                }

            }
        }
        maze[3][5] = new Spaces("ᗧ");
    }

    private void printGrid() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                System.out.print(maze[r][c].getSymbol());
            }
            System.out.println();
        }
    }

}