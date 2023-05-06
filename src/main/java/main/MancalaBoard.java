package main;

import main.styles.BoardStyle;
import main.styles.BoardStylePicker;
import main.styles.DefaultBoardStyle;

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
    private BoardStylePicker stylePicker;
    private final MancalaPit mancalaPitA;
    private final MancalaPit mancalaPitB;
    private final PitsPanel pitsPanel;

    /**
     * Creates a mancala board with two mancala pits and 12 regular pits
     * @param mancalaPitModel   the model used to hold the beads in the mancala pits
     * @param pitsModel         the model used to hold the beads within the regular pits
     */
    public MancalaBoard(Model<Integer> mancalaPitModel, Model<Integer> pitsModel) {

        stylePicker = new BoardStylePicker(new DefaultBoardStyle());
        setLayout(new BorderLayout(25,25));

        mancalaPitA = new MancalaPit(mancalaPitModel, 0, stylePicker.getPitColor());
        mancalaPitB = new MancalaPit(mancalaPitModel, 1, stylePicker.getPitColor());
        pitsPanel = new PitsPanel(pitsModel, mancalaPitModel, stylePicker.getPitColor());
        pitsPanel.setBackground(stylePicker.getBoardColor());

        add(mancalaPitA, BorderLayout.WEST);
        add(mancalaPitB, BorderLayout.EAST);
        add(pitsPanel, BorderLayout.CENTER);
        setBackground(stylePicker.getBoardColor());
    }

    /**
     * Sets the style of the board.
     * @param style the style to be used
     */
    public void setStyle(BoardStyle style) {
        stylePicker = new BoardStylePicker(style);
        setBackground(stylePicker.getBoardColor());
        pitsPanel.setBackground(stylePicker.getBoardColor());
        pitsPanel.setFontColor(stylePicker.getFontColor());
        mancalaPitA.setColor(stylePicker.getPitColor());
        mancalaPitB.setColor(stylePicker.getPitColor());
        mancalaPitA.setFontColor(stylePicker.getFontColor());
        mancalaPitB.setFontColor(stylePicker.getFontColor());
        for (Pit pit : pitsPanel.getPits()) {
            pit.setColor(stylePicker.getPitColor());
        }
    }
}
