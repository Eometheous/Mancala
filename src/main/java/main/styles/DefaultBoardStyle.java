package main.styles;

import java.awt.*;

/**
 * The default style for the mancala board which uses brown colors to match
 * that of a wooden board.
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class DefaultBoardStyle implements BoardStyle{
    private Color boardColor, fontColor, pitColor;

    /**
     * Sets the colors for the default style
     * @author Jonathan Stewart Thomas
     */
    public DefaultBoardStyle() {
        boardColor = new Color(163, 114, 46);
        fontColor = new Color(0,0,0);
        pitColor = new Color(133, 91, 17);
    }

    /**
     * Gets the font color for this style
     * @author Jonathan Stewart Thomas
     * @return  the mancalaPitColor
     */
    @Override
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * Gets the pit color for this style
     * @author Jonathan Stewart Thomas
     * @return  the pit color
     */
    @Override
    public Color getPitColor() {
        return pitColor;
    }

    /**
     * Gets the board color for this style
     * @author Jonathan Stewart Thomas
     * @return  the board color
     */
    @Override
    public Color getBoardColor() {
        return boardColor;
    }

    /**
     * Sets the font color for this style
     * @author Jonathan Stewart Thomas
     * @param color the color for the font
     */
    @Override
    public void setFontColor(Color color) {
        fontColor = color;
    }

    /**
     * Sets the pit color for this style
     * @author Jonathan Stewart Thomas
     * @param color the color for the pits
     */
    @Override
    public void setPitColor(Color color) {
        pitColor = color;
    }

    /**
     * Sets the board color for this style
     * @param color the color for the board
     */
    @Override
    public void setBoardColor(Color color) {
        boardColor = color;
    }

}
