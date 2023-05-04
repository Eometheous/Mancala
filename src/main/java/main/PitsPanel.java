package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class stores and displays the 12 pits for the Mancala Board game in a grid layout.
 * @author Kelly Dang
 * @version 1.2.0.230426
 */

public class PitsPanel extends JPanel {
    private final ArrayList<Pit> pits;
    private final ArrayList<JLabel> pitLabels;
    public PitsPanel(Model<Integer> m, Model<Integer> p, Color color) {
        pits = new ArrayList<>();
        pitLabels = new ArrayList<>();
        setLayout(new GridLayout(2, 6, 25, 25));
        
        /// top row
        
        for(int i = 6; i >= 1; i--) {
            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("B" + Integer.toString(i));
            label.setHorizontalAlignment(JLabel.CENTER);
            pitLabels.add(label);
            panel.add(label, BorderLayout.NORTH);
            Pit pit = new Pit(m, p,i - 1, color);
            panel.add(pit, BorderLayout.CENTER);
            pits.add(pit);
            panel.setOpaque(false);
            add(panel);
        } 
        
        // bottom row
        
        for(int i = 0; i < 6; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("A" + Integer.toString(i + 1));
            label.setHorizontalAlignment(JLabel.CENTER);
            pitLabels.add(label);
            panel.add(label, BorderLayout.SOUTH);
            Pit pit = new Pit(m, p,i + 6, color);
            panel.add(pit, BorderLayout.CENTER);
            pits.add(pit);
            panel.setOpaque(false);
            add(panel);
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
    /**
    * Sets the font color of the labels based off styles
    * @author Andy Wang
    */
    public void setFontColor(Color c) {
    	for(JLabel l: pitLabels) {
    		l.setForeground(c);
    	}
    }
}
