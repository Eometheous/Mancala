package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

/**
 * <p>
 *     A pit for the Mancala board. A Pit contains beads
 *     which are read from the {@code Model}.
 * </p>
 * @author Jonathan Stewart Thomas
 * @version 1.1.0.230426
 */
public class Pit extends JPanel implements ChangeListener {
    public static final int PIT_WIDTH_AND_HEIGHT = 105;
    private final Model<Integer> beadsModel;
    private final ArrayList<BeadIcon> beads;
    private final int pitNumber;
    private Color color;
    public Pit(Model<Integer> model, int pitNumber, Color color) {
        beadsModel = model;
        beads = new ArrayList<>();

        for (int i = 0; i < model.get(pitNumber); i++) {
            beads.add(new BeadIcon(15));
        }

        this.pitNumber = pitNumber;
        setPreferredSize(new Dimension(PIT_WIDTH_AND_HEIGHT, PIT_WIDTH_AND_HEIGHT));
        setSize(PIT_WIDTH_AND_HEIGHT, PIT_WIDTH_AND_HEIGHT);
        beadsModel.attach(this);
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Model<Integer> mancalaPitsModel = new Model<>();
                mancalaPitsModel.add(0);
                mancalaPitsModel.add(0);

                Mancala m = new Mancala(mancalaPitsModel, model);
                m.pickUp(pitNumber);
            }
        };
        addMouseListener(adapter);

        this.color = color;
    }

    /**
     * Sets the color for this pit
     * @param color the color to use
     */
    public void setColor(Color color) {
        this.color = color;
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
        g2.setColor(color);
        g2.fill(pitColor);
        BeadPainter.paintBeads(beads, this, g, PIT_WIDTH_AND_HEIGHT);
    }

    /**
     * Updates the pit to display the correct amount of beads
     * @author Jonathan Stewart Thomas
     * @param e  a ChangeEvent object
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        while (beads.size() != beadsModel.get(pitNumber)) {
            if (beads.size() > beadsModel.get(pitNumber)) {
                beads.remove(beads.get(beads.size() - 1));
            }
            else beads.add(new BeadIcon(15));
        }
        getParent().repaint();
    }
}
