package main;

import javax.swing.*;
import java.awt.*;

/**
 * Contains the main method for this program.
 * It creates and initializes the two models and
 * all GUI components.
 * @author Jonathan Stewart Thomas
 */
public class MancalaTest {
    /**
     * The main method of this program. It creates and initializes the two models
     * and all GUI components.
     * @author Jonathan Stewart Thomas
     * @param args  not used for anything
     */
    public static void main(String[] args) {
        Model<Integer> pitsModel = new Model<>();
        for (int i = 0; i < 12; i++) {
            pitsModel.add(0);
        }
        Model<Integer> mancalaPitsModel = new Model<>();
        mancalaPitsModel.add(0);
        mancalaPitsModel.add(0);

        MancalaBoard board = new MancalaBoard(mancalaPitsModel, pitsModel);

        GameStatus bar = new GameStatus(pitsModel, board, mancalaPitsModel);

        JFrame frame = new JFrame("Mancala");
        frame.setLayout(new BorderLayout());
        frame.add(board,BorderLayout.CENTER);
        frame.add(bar,BorderLayout.NORTH);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
