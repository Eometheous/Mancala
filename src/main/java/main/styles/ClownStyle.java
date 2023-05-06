package main.styles;

import java.awt.*;

/**
 * This is the clown style for the mancala board
 * @author Kelly Dang
 * @version 1.0.0.230428
 */
public class ClownStyle extends DefaultBoardStyle {
    /**
     * Sets the colors for the Clown style
     * @author Kelly Dang
     */
    public ClownStyle() {
        setBoardColor(new Color(255, 0, 0));
        setPitColor(new Color(255, 255, 0));
        setFontColor(new Color(0, 0, 0));
    }
}
