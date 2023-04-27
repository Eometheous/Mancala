package Styles;

import java.awt.*;

/**
 * A dark mode style for the mancala board
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class KimStyle implements BoardStyle{
    private final Color boardColor, fontColor, pitColor;

    /**
     * Sets the colors for the dark style
     */
    public KimStyle() {
        boardColor = new Color(50, 205, 50);
        fontColor = new Color(0, 0, 0);
        pitColor = new Color(255, 255, 102);
    }

    /**
     * @return  the mancalaPitColor
     */
    @Override
    public Color setFontColor() {
        return fontColor;
    }

    /**
     * @return  the pit color
     */
    @Override
    public Color setPitColor() {
        return pitColor;
    }

    /**
     * @return  the board color
     */
    @Override
    public Color setBoardColor() {
        return boardColor;
    }
}
