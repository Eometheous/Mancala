package styles;

import java.awt.*;

/**
 * A Valorant mode style for the mancala board
 * @author Andy Wang
 * @version 1.0.0.230428
 */
public class ValorantStyle implements BoardStyle{
    private final Color boardColor, fontColor, pitColor;

    /**
     * Sets the colors for the dark style
     */
    public DarkModeStyle() {
        boardColor = new Color(255, 81, 82);
        fontColor = new Color(255,81,82);
        pitColor = new Color(12, 24, 36);
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
