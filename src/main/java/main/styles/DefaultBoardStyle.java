package main.styles;

import java.awt.*;

/**
 * The default style for the mancala board which uses brown colors to match
 * that of a wooden board.
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class DefaultBoardStyle implements BoardStyle{
    private final Color boardColor, fontColor, pitColor;

    /**
     * Sets the colors for the default style
     */
    public DefaultBoardStyle() {
        boardColor = new Color(163, 114, 46);
        fontColor = new Color(0,0,0);
        pitColor = new Color(133, 91, 17);
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
