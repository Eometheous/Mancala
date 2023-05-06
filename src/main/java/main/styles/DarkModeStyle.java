package main.styles;

import java.awt.*;

/**
 * A dark mode style for the mancala board
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230426
 */
public class DarkModeStyle extends DefaultBoardStyle{

    /**
     * Sets the colors for the dark mode style
     * @author Jonathan Stewart Thomas
     */
    public DarkModeStyle() {
        setBoardColor(new Color(0, 0, 0));
        setPitColor(new Color(73, 73, 73));
        setFontColor(new Color(255,255,255));
    }
}
