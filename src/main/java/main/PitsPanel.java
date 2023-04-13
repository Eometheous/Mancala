package main;

import javax.swing.*;
import java.awt.*;

public class PitsPanel extends JPanel {
    public PitsPanel(Model<Integer> m) {
        setLayout(new GridLayout(2, 6));
        for(int i = 0; i < 12; i++) {
            add(new Pit(m, i));
        }
    }
}
