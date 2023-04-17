import main.Model;
import main.Pit;

import javax.swing.*;

public class PitTest {
    public static void main(String[] args) {
        Model<Integer> model = new Model<>();
        model.add(5);
        Pit pit = new Pit(model, 0);
        JFrame frame = new JFrame("Testing Pit");
        frame.add(pit);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
