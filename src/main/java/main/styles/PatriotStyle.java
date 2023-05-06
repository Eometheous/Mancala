package main.styles;

import java.awt.*;
/**
 * A patriotic theme style board using red, white, and blue.
 * @author Jeffrey Van
 * @version 1.0.0.230504
 */
public class PatriotStyle implements BoardStyle {
    private final Color board;
    private final Color pit;
    private final Color font;

    /**
     * Default constructor for the patriot style. Red, white and blue.
     * @author Jeffrey Van
     */
    public PatriotStyle() {
        board = new Color(0,33,71);
        pit = new Color(201, 14, 14);
        font = new Color(255,255,255);
    }

    /**
     * sets the color of the font
     * @author Jeffrey Van
     * @return the color of the font
     */
    @Override
    public Color getFontColor() {
        return font;
    }

    /**
     * sets the color of the pits
     * @author Jeffrey Van
     * @return the color of the pits
     */
    @Override
    public Color getPitColor() {
        return pit;
    }

    /**
     * sets the color of the board
     * @author Jeffrey Van
     * @return the color of the board
     */
    @Override
    public Color getBoardColor() {
        return board;
    }
}
