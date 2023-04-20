package main;

import javax.swing.*;
import java.awt.*;

/**
 * This class stores and displays the 12 pits for the Mancala Board game in a grid layout.
 * @author Kelly Dang
 * @version 1.0.0.230413
 */
public class PitsPanel extends JPanel {
    public PitsPanel(Model<Integer> m) {
        setLayout(new GridLayout(2, 6, 25, 25));
        for(int i = 0; i < 12; i++) {
            add(new Pit(m, i));
        }
    }
}
