package main;

import java.awt.*;

public class DefaultBoardStyle implements BoardStyle{
    Color boardColor, mancalaPitColor, pitColor;
    public DefaultBoardStyle() {
        boardColor = new Color(163, 114, 46);
        mancalaPitColor = new Color(133, 91, 17);
        pitColor = new Color(133, 91, 17);
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
