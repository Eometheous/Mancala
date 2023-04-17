import main.Model;
import main.Pit;

import javax.swing.*;
import java.awt.*;

/**
 * Tests the Pit class
 * @author Jonathan Stewart Thomas
 */
public class PitTest {
    public static void main(String[] args) {
        Model<Integer> model = new Model<>();
        model.add(5);
        model.add(4);
        Pit pit1 = new Pit(model, 0);
        Pit pit2 = new Pit(model, 1);
        JFrame frame = new JFrame("Testing Pit");
        frame.add(pit1);
        frame.add(pit2);
        frame.setLayout(new GridLayout(1, 2, 25, 25));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
