package main;

import java.awt.*;

/**
 * A board style picker which follows the strategy pattern.
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class BoardStylePicker implements BoardStyle{
    BoardStyle style;

    /**
     * Initializes this with a specific style
     * @param style the style to use
     */
    BoardStylePicker(BoardStyle style) {
        this.style = style;
    }

    /**
     * @return  the color for the mancala pit
     */
    @Override
    public Color setMancalaPitColor() {
        return style.setMancalaPitColor();
    }

    /**
     * @return the color for regular pits
     */
    @Override
    public Color setPitColor() {
        return style.setPitColor();
    }

    /**
     * @return the color for the board
     */
    @Override
    public Color setBoardColor() {
        return style.setBoardColor();
    }
}
