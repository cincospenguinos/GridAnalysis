package diagonal_path;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel meant to draw the grid
 *
 * Created by tsvetok on 6/15/16.
 */
public class GridPanel extends JPanel {

    // Model stuff
    private Grid grid;

    // View stuff
    private final int X_PADDING = 5;
    private final int Y_PADDING = 5;

    public GridPanel(int startLength, int startHeight){
        grid = new Grid(startLength, startHeight);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Let's setup some variables
        double gridWidth = (double)(this.getWidth() - X_PADDING);
        double gridHeight = (double) (this.getHeight() - Y_PADDING);

        g.drawRect(X_PADDING, Y_PADDING, this.getWidth() - X_PADDING * 2, getHeight() - Y_PADDING * 2);

        // Now let's draw rows and columns
        for(double cols = 0; cols < grid.getGridLength(); cols += 1.0){
            int xPos = (int)(gridWidth * (cols + 1.0) / grid.getGridLength());
            int y1 = Y_PADDING;
            int y2 = (int)gridHeight;

            g.drawLine(xPos, y1, xPos, y2);
        }

        for(double rows = 0; rows < grid.getGridHeight(); rows += 1.0){
            int yPos = (int)(gridHeight * (rows + 1.0) / grid.getGridHeight());
            int x1 = X_PADDING;
            int x2 = (int)gridWidth;

            g.drawLine(x1, yPos, x2, yPos);
        }

        // And now the path
        g.setColor(Color.RED);
        ArrayList<Pair<Integer, Integer>> topPath = grid.getTopPath().getPath();
        for(int i = 1; i < topPath.size(); i++){
            Pair point1 = topPath.get(i - 1);
            Pair point2 = topPath.get(i);

            int x1 = (int)(gridWidth * ((int)point1.getObj1()) / grid.getGridLength());
            int y1 = (int)(gridHeight * ((int)point1.getObj2()) / grid.getGridHeight());
            int x2 = (int)(gridWidth * ((int)point2.getObj1()) / grid.getGridLength());
            int y2 = (int)(gridHeight * ((int)point2.getObj2()) / grid.getGridHeight());

            g.drawLine(x1, y1, x2, y2);
        }
    }
}
