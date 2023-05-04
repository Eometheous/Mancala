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

    public PatriotStyle() {
        board = new Color(0,33,71);
        pit = new Color(201, 14, 14);
        font = new Color(255,255,255);
    }

    /**
     * sets the color of the font
     * @return the color of the font
     */
    @Override
    public Color setFontColor() {
        return font;
    }

    /**
     * sets the color of the pits
     * @return the color of the pits
     */
    @Override
    public Color setPitColor() {
        return pit;
    }

    /**
     * sets the color of the board
     * @return the color of the board
     */
    @Override
    public Color setBoardColor() {
        return board;
    }
}
