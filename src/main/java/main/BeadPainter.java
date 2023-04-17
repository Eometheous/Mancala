package main;

import java.awt.*;
import java.util.ArrayList;

public class BeadPainter extends BeadIcon{
    public static void paintBeads(ArrayList<BeadIcon> beads, Component c, Graphics g, int constraints) {
        int x = 15, y = 15;
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
