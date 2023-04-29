package styles;

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
     * @param style the style to use
     */
    public BoardStylePicker(BoardStyle style) {
        this.style = style;
    }

    /**
     * @return  the color for the mancala pit
     */
    @Override
    public Color setFontColor() {
        return style.setFontColor();
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
