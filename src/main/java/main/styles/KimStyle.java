package main.styles;

import java.awt.*;

/**
 * A style matching the colors of Kim's website for the mancala board
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class KimStyle extends DefaultBoardStyle{

    /**
     * Sets the colors for the Kim style
     * @author Jonathan Stewart Thomas
     */
    public KimStyle() {
        setBoardColor(new Color(50, 205, 50));
        setFontColor(new Color(0, 0, 238));
        setPitColor(new Color(255, 255, 102));
    }
}
