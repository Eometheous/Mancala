package main;

import Styles.BoardStyle;
import Styles.BoardStylePicker;
import Styles.DefaultBoardStyle;

import javax.swing.*;
import java.awt.*;

/**
 * A mancala board containing two mancala pits and 12 regular pits
 * The board initially uses a default board style, but the style can
 * be changed with setStyle.
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class MancalaBoard extends JPanel {
    BoardStylePicker stylePicker;
    MancalaPit mancalaPitA, mancalaPitB;
    PitsPanel pitsPanel;
    Model<Integer> mancalaPitModel;
    Model<Integer> pitsModel;

    /**
     * Creates a mancala board with two mancala pits and 12 regular pits
     * @param mancalaPitModel   the model used to hold the beads in the mancala pits
     * @param pitsModel         the model used to hold the beads within the regular pits
     */
    public MancalaBoard(Model<Integer> mancalaPitModel, Model<Integer> pitsModel) {
        this.mancalaPitModel = mancalaPitModel;
        this.pitsModel = pitsModel;

        stylePicker = new BoardStylePicker(new DefaultBoardStyle());
        setLayout(new BorderLayout(25,25));

        mancalaPitA = new MancalaPit(mancalaPitModel, 0, stylePicker.setPitColor());
        mancalaPitB = new MancalaPit(mancalaPitModel, 1, stylePicker.setPitColor());
        pitsPanel = new PitsPanel(pitsModel, stylePicker.setPitColor());
        pitsPanel.setBackground(stylePicker.setBoardColor());

        add(mancalaPitA, BorderLayout.WEST);
        add(mancalaPitB, BorderLayout.EAST);
        add(pitsPanel, BorderLayout.CENTER);
        setBackground(stylePicker.setBoardColor());
    }

    /**
     * Sets the style of the board.
     * @param style the style to be used
     */
    public void setStyle(BoardStyle style) {
        stylePicker = new BoardStylePicker(style);
        setBackground(stylePicker.setBoardColor());
        pitsPanel.setBackground(stylePicker.setBoardColor());
        pitsPanel.setFontColor(stylePicker.setFontColor());
        mancalaPitA.setColor(stylePicker.setPitColor());
        mancalaPitB.setColor(stylePicker.setPitColor());
        for (Pit pit : pitsPanel.getPits()) {
            pit.setColor(stylePicker.setPitColor());
        }
    }
}
