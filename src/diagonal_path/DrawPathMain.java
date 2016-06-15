package diagonal_path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The view and controller of the entire little application. This will hopefully let us explore some interesting
 * things in the little puzzle I've picked up and played with since I was little.
 *
 * In case someone other than me reads this, here's the puzzle:
 *
 * Imagine you have a grid of size n by m. Starting at the top left corner of the grid, move diagonally in a single
 * direction until you cannot anymore. If you hit an edge of the grid, move the opposite direction of that edge (so
 * if you can't move down anymore, then move up, and if you can't move right anymore, move left.) If you reach a
 * corner of the grid, then you are done.
 *
 * I've always wondered what sorts of dimensions brought about what types of paths and what kinds of symmetry would
 * present themselves according to what type of
 *
 * Created by tsvetok on 6/14/16.
 */
public class DrawPathMain extends JFrame implements ActionListener {

    // View stuff
    private JLabel gridDimensionsLabel;

    private JButton updateButton;

    private JTextArea lengthAmount;
    private JTextArea heightAmount;

    private GridPanel gridPanel;

    public static void main(String[] args) {
        new DrawPathMain().setVisible(true);
    }

    public DrawPathMain() {
        // Setup the model
        int startLength = 2;
        int startHeight = 3;

        // Instantiate the various variables
        gridDimensionsLabel = new JLabel();
        gridDimensionsLabel.setText(startLength + " by " + startHeight);

        updateButton = new JButton("Draw grid");
        updateButton.addActionListener(this);

        lengthAmount = new JTextArea(Integer.toString(startLength));
        heightAmount = new JTextArea(Integer.toString(startHeight));
        gridPanel = new GridPanel(startLength, startHeight);

        // Setup all the view stuff
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));
        JPanel amountPanel = new JPanel();

        amountPanel.setLayout(new GridLayout(2, 2));
        amountPanel.add(new JLabel("Length"));
        amountPanel.add(lengthAmount);
        amountPanel.add(new JLabel("Height"));
        amountPanel.add(heightAmount);

        southPanel.add(amountPanel);
        southPanel.add(updateButton);
        add(southPanel, BorderLayout.SOUTH);
        add(gridDimensionsLabel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: this
        try {
            String number1 = lengthAmount.getText();
            String number2 = heightAmount.getText();

            int width = Integer.parseInt(number1);
            int height = Integer.parseInt(number2);

            if(width > 0 && height > 0){
                gridPanel.newGrid(width, height);
                gridDimensionsLabel.setText(width + " by " + height);
            }
        } catch (Exception ex) {
            return;
        }
    }
}
