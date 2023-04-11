package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * <p>
 *     A pit for the Mancala board. A Pit contains beads
 *     which are read from the {@code Model}.
 * </p>
 * @author Jonathan Stewart Thomas
 * @version 1.0.0.230410
 */
public class Pit extends JPanel implements ChangeListener {
    Model<Integer> beadsModel;
    int pitNumber;
    public Pit(int pitNumber) {
        beadsModel = new Model<>();
        this.pitNumber = pitNumber;

        beadsModel.attach(this);
    }

    /**
     * Paints the bead icons
     * @author Jonathan Stewart Thomas
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        int numberOfBeads = beadsModel.get(pitNumber);
        for (int i = 0; i < numberOfBeads; i++) {
            // TODO add BeadICON and call paintIcon
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
