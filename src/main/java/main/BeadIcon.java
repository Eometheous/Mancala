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


    int radius;
    Color beadColor;
    int colorCode;
    double colorValue;



    public BeadIcon() {
         radius = 15;
         colorValue = Math.random();
         colorCode = Color.HSBtoRGB((float) colorValue, 0.5f, 0.5f);
         beadColor = new Color(colorCode);
    }

    public BeadIcon(int newRadius) {
        radius = newRadius;
        colorValue = Math.random();
        colorCode = Color.HSBtoRGB((float) colorValue, 0.5f, 0.5f);
        beadColor = new Color(colorCode);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, radius, radius);


        g2.setColor(beadColor);
        g2.fill(circle);

        g2.setColor(Color.black);
        g2.draw(circle);
    }

    @Override
    public int getIconWidth() {
        return radius;
    }

    @Override
    public int getIconHeight() {
        return radius;
    }
}