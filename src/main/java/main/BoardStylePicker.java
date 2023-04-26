package main;

import java.awt.*;

public class BoardStylePicker implements BoardStyle{
    BoardStyle style;
    BoardStylePicker(BoardStyle style) {
        this.style = style;
    }

    @Override
    public Color setMancalaPitColor() {
        return style.setMancalaPitColor();
    }

    @Override
    public Color setPitColor() {
        return style.setPitColor();
    }

    @Override
    public Color setBoardColor() {
        return style.setBoardColor();
    }
}
