package main.styles;

import java.awt.*;

/**
 * This is the clown style for the mancala board
 * @author Kelly Dang
 * @version 1.0.0.230428
 */
public class ClownStyle implements BoardStyle {
    private final Color board;
    private final Color pit;
    private final Color font;

    public ClownStyle() {
        board = new Color(255, 0, 0);
        pit = new Color(255, 255, 0);
        font = new Color(0, 0, 0);
    }

    /**
     * sets the color of the font
     * @return the color of the font
     */
    @Override
    public Color getFontColor() {
        return font;
    }

    /**
     * sets the color of the pits
     * @return the color of the pits
     */
    @Override
    public Color getPitColor() {
        return pit;
    }

    /**
     * sets the color of the board
     * @return the color of the board
     */
    @Override
    public Color getBoardColor() {
        return board;
    }
}
