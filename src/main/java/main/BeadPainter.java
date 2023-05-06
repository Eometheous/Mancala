package main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Paints BeadIcons
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230417
 */
public class BeadPainter {
    /**
     * Paints BeadIcons with constraints for the x-axis
     * @author Jonathan Stewart Thomas
     * @param beads         the beads being painted
     * @param c             the component the beads are a part of
     * @param g             the graphics to paint the beads
     * @param constraints   the x-axis constraints
     */
    public static void paintBeads(ArrayList<BeadIcon> beads, Component c, Graphics g, int constraints, int y) {
        int x = 15;
        for (BeadIcon bead : beads) {
            bead.paintIcon(c, g, x, y);
            x += bead.getIconWidth() + 5;
            if (x > constraints - bead.getIconWidth() * 2) {
                x = 15;
                y += bead.getIconHeight() + 5;
            }
        }
    }
}
