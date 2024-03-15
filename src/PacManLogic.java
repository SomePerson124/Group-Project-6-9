public class PacManLogic {

    Spaces[][] grid;


    public PacManLogic() {
        grid = new Spaces[20][151];
        printGrid();
    }

    private void printGrid() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new Spaces("_");
                System.out.print(grid[r][c].getSymbol());
            }
            System.out.println();
        }
    }

}