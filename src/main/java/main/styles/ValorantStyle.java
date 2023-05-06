package main.styles;

import java.awt.*;

/**
 * A Valorant mode style for the mancala board
 * @author Andy Wang
 * @version 1.0.0.230428
 */
public class ValorantStyle extends DefaultBoardStyle{

    /**
     * Sets the colors for the Valorant style
     * @author Andy Wang
     */
    public ValorantStyle() {
        setBoardColor(new Color(255, 81, 82));
        setPitColor(new Color(12, 24, 36));
        setFontColor(new Color(12, 24, 36));
    }
}
