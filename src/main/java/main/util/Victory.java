package main.util;

import main.GameStatus;
import main.Model;

import javax.swing.*;
/**
 * The Victory class is a utility class that helps the game determine the winner. If there is no winner
 * then a draw is determined and called upon.
 * @author Jeffrey Van
 * @version 1.0.0.230505
 *
 */
public class Victory extends JPanel {
     static Model<Integer> beadsModel;
     static  Model<Integer> mancalaPitsModel;

    /**
     * The checkVictory method takes in a panel for the JOptionPane popup. It will check if the game is started,
     * and if the game is started then it will check if there is a winner based on how many empty pits exist. If a winner
     * exists, then we shall display it and clear the board.
     * @author Jeffrey Van
     * @param panel takes in a panel for the JOptionPane popup
     */
    public static void checkVictory(JPanel panel) {
        if (GameStatus.started) {
            boolean isPlayerB;
            int counter = 0, counterTwo = 0;

            for (int i = 0; i < 6; i++) {
                if (beadsModel.get(i) == 0) {
                    counter++;
                }
            }
            for (int i = 6; i < 12; i++) {
                if (beadsModel.get(i) == 0) {
                    counterTwo++;
                }
            }
            if (counter == 6 || counterTwo == 6) {
                takeAll(counter > counterTwo);
                isPlayerB = mancalaPitsModel.get(0) > mancalaPitsModel.get(1);
                boolean isDraw = mancalaPitsModel.get(0).equals(mancalaPitsModel.get(1));
                JLabel label = new JLabel();

                if(isDraw){
                    label.setText("Draw!");
                }
                else if (isPlayerB) {
                    label.setText("Player B Victory! B won with :" + mancalaPitsModel.get(0)
                    + " | Player A : " +mancalaPitsModel.get(1) +" beads");
                } else {
                    label.setText("Player A Victory! A won with : "+ mancalaPitsModel.get(1)
                    + " | Player B : " +mancalaPitsModel.get(0) +" beads");
                }
                JOptionPane.showMessageDialog(panel,label, "Winner Decided!", JOptionPane.INFORMATION_MESSAGE);
                GameStatus.started = false;
                clearBoard();
            }
        }
    }


    /**
     * Initializes the static variables to the passed in models to be used.
     * @author Jeffrey Van
     * @param model Bead Model
     * @param pitsModel Pits Model of the players
     */
    public static void initializer(Model<Integer> model, Model<Integer> pitsModel){
        beadsModel = model;
        mancalaPitsModel = pitsModel;
    }

    /**
     * Take all the beads depending on if one side is empty or not.
     * @author Jeffrey Van
     * @param isPlayerBEmpty if player B's side is empty or player A side is empty.
     */
    private static void takeAll(boolean isPlayerBEmpty){
        if(isPlayerBEmpty){
            for (int i = 6; i < 12; i++) {
                mancalaPitsModel.update(1, mancalaPitsModel.get(1) + beadsModel.get(i));
            }
        }
        else{
            for (int i = 0; i < 6; i++) {
                mancalaPitsModel.update(0,mancalaPitsModel.get(0) +beadsModel.get(i));
            }

        }

    }

    /**
     * Clear the board for next game.
     * @author Jeffrey Van
     */
    private static void clearBoard(){
        for (int i = 0; i < 12; i++) {
            beadsModel.update(i, 0);
        }
        mancalaPitsModel.update(0, 0);
        mancalaPitsModel.update(1, 0);
    }


}
