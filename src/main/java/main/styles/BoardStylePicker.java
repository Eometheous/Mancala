package main.styles;

import java.awt.*;

/**
 * A board style picker which follows the strategy pattern.
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class BoardStylePicker implements BoardStyle{
    private final BoardStyle style;

    /**
     * Initializes this with a specific style
     * @author Jonathan Stewart Thomas
     * @param style the style to use
     */
    public BoardStylePicker(BoardStyle style) {
        this.style = style;
    }

    /**
     * Sets the font color for this style
     * @author Jonathan Stewart Thomas
     * @return  the color for the mancala pit
     */
    @Override
    public Color getFontColor() {
        return style.getFontColor();
    }

    /**
     * Sets the pit color for this style
     * @author Jonathan Stewart Thomas
     * @return the color for regular pits
     */
    @Override
    public Color getPitColor() {
        return style.getPitColor();
    }

    /**
     * @return the color for the board
     */
    @Override
    public Color getBoardColor() {
        return style.getBoardColor();
    }
}
