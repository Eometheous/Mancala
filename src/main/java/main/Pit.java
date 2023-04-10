package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Pit extends JPanel implements ChangeListener {
    Model<Integer> beadsModel;
    int pitNumber;
    public Pit(int pitNumber) {
        beadsModel = new Model<>();
        this.pitNumber = pitNumber;

        beadsModel.attach(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int numberOfBeads = beadsModel.get(pitNumber);
        for (int i = 0; i < numberOfBeads; i++) {
            // TODO add BeadICON and call paintIcon
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }
}
