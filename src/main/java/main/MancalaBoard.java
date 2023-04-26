package main;

import javax.swing.*;
import java.awt.*;

public class MancalaBoard extends JPanel {
    BoardStylePicker stylePicker;
    public MancalaBoard(Model<Integer> mancalaPitModel, Model<Integer> pitsModel) {
        stylePicker = new BoardStylePicker(new DefaultBoardStyle());
        setLayout(new BorderLayout());
        add(new MancalaPit(mancalaPitModel, 0), BorderLayout.WEST);
        add(new MancalaPit(mancalaPitModel, 1), BorderLayout.EAST);
        add(new PitsPanel(pitsModel), BorderLayout.CENTER);
        setBackground(stylePicker.setBoardColor());
    }
    public void setStyle(BoardStyle style) {
        stylePicker = new BoardStylePicker(style);
    }
}
