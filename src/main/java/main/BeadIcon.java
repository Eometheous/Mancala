package main;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


/**
 * BeadIcon.java class creates a single instance of a bead to be used in the Mancala main project game. It creates a
 * bead of radius size 25, and assigns a random color value to it and places it based on the xy coordinate passed in.
 * @author Jeffrey Van
 * @version 1.1.2.230420
 */


public class BeadIcon implements Icon {
    private final int radius;
    private final Color beadColor;
    private final int colorCode;
    private final double colorValue;

    /**
     * Default constructor for an individual bead. The user can call this if they want just a default style
     */
    public BeadIcon() {
         radius = 15;
         colorValue = Math.random();
         colorCode = Color.HSBtoRGB((float) colorValue, 0.5f, 0.5f);
         beadColor = new Color(colorCode);
    }

    /**
     * A constructor that has a parameter that takes in a designated radius size, sets the bead to radius size.
     * @param newRadius a radius to set the beads to.
     */
    public BeadIcon(int newRadius) {
        radius = newRadius;
        colorValue = Math.random();
        colorCode = Color.HSBtoRGB((float) colorValue, 0.5f, 0.5f);
        beadColor = new Color(colorCode);
    }

    /**
     * Paint icon paints the individual bead
     * @param c Component
     * @param g Graphics to draw with
     * @param x The x coordinate, where the bead is to be drawn
     * @param y The y coordinate, where the bead is to be drawn
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, radius, radius);

        g2.setColor(beadColor);
        g2.fill(circle);

        g2.setColor(Color.black);
        g2.draw(circle);
    }

    /**
     * Getter method to get the width of the bead
     * @return which is the icon width
     */
    @Override
    public int getIconWidth() {
        return radius;
    }

    /**
     * Getter method that returns the icon height of bead
     * @return radius which is the icon height
     */
    @Override
    public int getIconHeight() {
        return radius;
    }
}