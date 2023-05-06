package main.styles;

import java.awt.*;
/**
 * A patriotic theme style board using red, white, and blue.
 * @author Jeffrey Van
 * @version 1.0.0.230504
 */
public class PatriotStyle extends DefaultBoardStyle {

    /**
     * Default constructor for the patriot style. Red, white and blue.
     * @author Jeffrey Van
     */
    public PatriotStyle() {
        setBoardColor(new Color(0,33,71));
        setPitColor(new Color(201, 14, 14));
        setFontColor(new Color(255,255,255));
    }
}
