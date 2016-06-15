package diagonal_path;

/**
 * Represents a grid in the diagonal path problem.
 *
 * Created by tsvetok on 6/14/16.
 */
public class Grid {

    private int[][] grid;
    private Path topPath, bottomPath;

    /**
     * Constructor of Grid
     *
     * @param _length - length of the grid horizontally
     * @param _height - width of the grid vertically
     */
    public Grid (int _length, int _height) {
        if(_length <= 0 || _height <= 0)
            throw new RuntimeException("A grid cannot have a height or length less than or equal to zero!");

        grid = new int[_length + 1][_height + 1];
    }

    public int getGirdLength(){
        return grid.length;
    }

    public int getGridHeight(){
        return grid[0].length;
    }

    public Path getTopPath(){
        return topPath;
    }

    public Path getBottomPath(){
        return bottomPath;
    }
}
