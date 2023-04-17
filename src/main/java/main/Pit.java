package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * <p>
 *     A pit for the Mancala board. A Pit contains beads
 *     which are read from the {@code Model}.
 * </p>
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230411
 */
public class Pit extends JPanel implements ChangeListener {
    public static final int PIT_WIDTH_AND_HEIGHT = 105;
    Model<Integer> beadsModel;
    int pitNumber;
    public Pit(Model<Integer> model, int pitNumber) {
        beadsModel = model;
        this.pitNumber = pitNumber;
        setPreferredSize(new Dimension(PIT_WIDTH_AND_HEIGHT, PIT_WIDTH_AND_HEIGHT));
        setSize(PIT_WIDTH_AND_HEIGHT, PIT_WIDTH_AND_HEIGHT);
        beadsModel.attach(this);
    }

    /**
     * Paints the bead icons
     * @author Jonathan Stewart Thomas
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        RoundRectangle2D pitColor = new RoundRectangle2D.Double(0, 0,
                PIT_WIDTH_AND_HEIGHT, PIT_WIDTH_AND_HEIGHT, 75, 75);
        g2.setColor(Color.ORANGE);
        g2.fill(pitColor);
        int numberOfBeads = beadsModel.get(pitNumber);
        int x = 15, y = 15;
        for (int i = 0; i < numberOfBeads; i++) {
            BeadIcon bead = new BeadIcon(15);
            bead.paintIcon(this, g, x, y);
            x += bead.getIconWidth() + 5;
            if (x > PIT_WIDTH_AND_HEIGHT - bead.getIconWidth() * 2) {
                x = 15;
                y += bead.getIconHeight() + 5;
            }
        }
    }

    /**
     * Updates the pit to display the correct amount of beads
     * @author Jonathan Stewart Thomas
     * @param e  a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }
}
