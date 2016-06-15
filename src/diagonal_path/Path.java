package diagonal_path;

import java.util.ArrayList;

/**
 * Represents a path through a grid.
 *
 * Created by tsvetok on 6/14/16.
 */
public class Path {

    private ArrayList<Pair<Integer, Integer>> path;

    public Path(int startX, int startY, int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            throw new RuntimeException("Cannot generate a path in a grid with incorrect dimensions!");

        path = new ArrayList<>();
        generatePath(startX, startY, grid);
    }

    /**
     * Helper method. Generates the list of points in the grid given their x and y coordinates.
     *
     * @param startX
     * @param startY
     * @param grid
     */
    private void generatePath(int startX, int startY, int[][] grid){
        int moveHorizontal = 1; // 1 means go right, -1 means go left
        int moveVertical = 1; // 1 means go down, -1 means go up

        path.add(new Pair<>(startX, startY));

        int xPos = startX;
        int yPos = startY;

        while(true) {
            boolean canMoveHorizontal = isLegalSpace(xPos + moveHorizontal, yPos, grid);
            boolean canMoveVertical = isLegalSpace(xPos, yPos + moveVertical, grid);

            // If we can't move horizontally and vertically, then we have hit a corner
            if(!canMoveHorizontal && !canMoveVertical)
                return;

            // If we only can't move in one direction, then we need to change directions
            if(!canMoveHorizontal)
                moveHorizontal = -moveHorizontal;
            else if(!canMoveVertical)
                moveVertical = -moveVertical;

            // Throw down the new point and call it a day
            xPos += moveHorizontal;
            yPos += moveVertical;
            path.add(new Pair<>(xPos, yPos));
        }
    }

    /**
     * Returns true if the position provided is a legal space on the grid.
     *
     * @param xPos
     * @param yPos
     * @param grid
     * @return
     */
    private boolean isLegalSpace(int xPos, int yPos, int[][] grid){
        try {
            int i = grid[xPos][yPos];
            return true;
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }


    public ArrayList<Pair<Integer, Integer>> getPath(){
        return path;
    }
}
