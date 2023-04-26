package main;

import java.awt.*;

public class DarkModeStyle implements BoardStyle{
    Color boardColor, mancalaPitColor, pitColor;
    public DarkModeStyle() {
        boardColor = new Color(0, 0, 0);
        mancalaPitColor = new Color(73, 73, 73);
        pitColor = new Color(73, 73, 73);
    }
    @Override
    public Color setMancalaPitColor() {
        return mancalaPitColor;
    }

    @Override
    public Color setPitColor() {
        return pitColor;
    }

    @Override
    public Color setBoardColor() {
        return boardColor;
    }
}
