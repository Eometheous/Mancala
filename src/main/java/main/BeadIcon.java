package main;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


/**
 * BeadIcon.java class creates a single instance of a bead to be used in the Mancala main project game. It creates a
 * bead of radius size 25, and assigns a random color value to it and places it based on the xy coordinate passed in.
 * @author Jeffrey Van
 * @version 1.0.0.23410
 */


public class BeadIcon implements Icon {


    int radius;


    public BeadIcon() {
        radius = 25;

    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2 = (Graphics2D) g;
        double colorValue = Math.random();
        int colorCode = Color.HSBtoRGB((float) colorValue, 0.5f, 0.5f);
        Ellipse2D circle = new Ellipse2D.Double(x, y, radius, radius);
        Color beadColor = new Color(colorCode);
        g2.setColor(beadColor);


        g2.fill(circle);


    }

    @Override
    public int getIconWidth() {
        return radius * 2;
    }

    @Override
    public int getIconHeight() {
        return radius * 2;
    }
}