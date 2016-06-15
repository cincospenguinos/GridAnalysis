package diagonal_path;

import javax.swing.*;
import java.awt.*;

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

        g.drawRect(X_PADDING, Y_PADDING, this.getWidth() - X_PADDING * 2, getHeight() - Y_PADDING * 2);
        // TODO: Draw the grid
    }
}
