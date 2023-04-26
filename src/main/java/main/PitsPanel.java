package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class stores and displays the 12 pits for the Mancala Board game in a grid layout.
 * @author Kelly Dang
 * @version 1.1.0.230426
 */
public class PitsPanel extends JPanel {
    private final ArrayList<Pit> pits;
    public PitsPanel(Model<Integer> m, Color color) {
        pits = new ArrayList<>();
        setLayout(new GridLayout(2, 6, 25, 25));
        for(int i = 0; i < 12; i++) {
            Pit pit = new Pit(m, i, color);
            pits.add(pit);
            add(pit);
        }
    }

    /**
     * Returns the pits that this panel holds
     * @author Jonathan Stewart Thomas
     * @return  the pits
     */
    public ArrayList<Pit> getPits() {
        return pits;
    }
}
