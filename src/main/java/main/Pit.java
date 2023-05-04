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
 * @version 1.2.0.230504
 */
public class Pit extends JPanel implements ChangeListener {
    public static final int PIT_WIDTH_AND_HEIGHT = 105;
    private final Model<Integer> beadsModel, mancalaPitModel;
    private final ArrayList<BeadIcon> beads;
    private final int pitNumber;
    private Color color;

    /**
     * The constructor for the Pit class. It takes in two models and a color for the pit background.
     * @author Jonathan Stewart Thomas
     * @param model             the model containing the number of beads
     * @param mancalaPitModel   the model containing the number of beads within the mancala pit
     * @param pitNumber         the pit number for this pit
     * @param color             the background color for this pit
     */
    public Pit(Model<Integer> model, Model<Integer> mancalaPitModel, int pitNumber, Color color) {
        beadsModel = model;
        this.mancalaPitModel = mancalaPitModel;
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

                pickUp(pitNumber);
            }
        };
        addMouseListener(adapter);

        this.color = color;
    }

    /**
     * Picks up the breads in the specified pit and places them in the other pits following the Mancala game rules.
     * @param pitNum    the pit the beads are being picked up from.
     * @author Kelly Dang
     */
    private void pickUp(int pitNum) {
        Undo.update(beadsModel, mancalaPitModel);
        int total = beadsModel.get(pitNum); // gets total num of stones
        beadsModel.update(pitNum, 0); // sets num of stones in this pit to be 0

        boolean crossed = false;
        boolean crossed2 = false;

        if (pitNum >= 0 && pitNum < 5) {
            pitNum++;
        } else if (pitNum > 5 && pitNum < 11) {
            pitNum++;
        } else if (pitNum == 5) {
            crossed = true;
        } else if (pitNum == 11) {
            crossed2 = true;
        }

        for (int i = 0; i < total; i++) {
            if (crossed) {
                int big = mancalaPitModel.get(0);
                big++;
                mancalaPitModel.update(0, big);
                pitNum = 6;
                crossed = false;
            } else if (crossed2) {
                int big = mancalaPitModel.get(1);
                big++;
                mancalaPitModel.update(1, big);
                pitNum = 0;
                crossed2 = false;
            } else if (pitNum <= 5 && pitNum >= 0) {
                int updated = beadsModel.get(pitNum);
                updated++;
                beadsModel.update(pitNum, updated);
                if (pitNum == 5) {
                    crossed = true;
                } else {
                    pitNum++;
                }
            } else if (pitNum >= 6 && pitNum <= 11) {
                int updated = beadsModel.get(pitNum);
                updated++;
                beadsModel.update(pitNum, updated);
                if (pitNum == 11) {
                    crossed2 = true;
                } else {
                    pitNum++;
                }
            }
        }
    }

    /**
     * Gets the opposite pit of the entered pit number
     * @author Jonathan Stewart Thomas
     * @param pitNumber the pit we are finding the opposite off
     * @return          the opposite pit
     */
    public int getOppositePitOf(int pitNumber) {
        return 12 - pitNumber - 1;
    }

    /**
     * Sets the color for this pit
     * @author Jonathan Stewart Thomas
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
        BeadPainter.paintBeads(beads, this, g, PIT_WIDTH_AND_HEIGHT, 15);
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
