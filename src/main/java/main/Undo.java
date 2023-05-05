package main;
/**
 * The Undo class is a class that contains static methods that are used to allow the user to undo. These methods are used
 * in the GameStatus class and the Pit class to have a save state of the board. This save state can be used to
 * undo a move that the user has done.
 * @author Jeffrey Van
 * @version 1.0.0.230504
 */

public class Undo{

    private static final Model<Integer> pitSaveState = new Model<>();
    private static final Model<Integer> mancalaPitSaveState = new Model<>();
    private static int undoCounter = 3;
    private static boolean isDisabled = false;

    /**
     * This static void method, it sets the model to the save state that we previously established.
     * @param model   the model used to hold the beads in the mancala pits
     * @param mancalaPitModel    the board containing all the pits
     */
    public static void undo(Model<Integer> model, Model<Integer> mancalaPitModel){
        if(undoCounter > 0 && !isDisabled) {
            GameStatus.updatePlayersTurn();
            for (int i = 0; i < 12; i++) {
                model.update(i, pitSaveState.get(i));
            }

            for (int i = 0; i < 2; i++) {
                mancalaPitModel.update(i, mancalaPitSaveState.get(i));
            }
            undoCounter--;
            isDisabled = true;
        }
    }

    /**
     * Resets the undo counter.
     */
    public static void resetUndoCounter(){
        undoCounter = 3;
    }

    /**
     * This static method initializes the save states to what the model or the mancala pit model is at the
     * start of the game.
     * @param model the model used to hold the beads in the mancala pits
     * @param mancalaPitModel the board containing all the pits
     */
    public static void initializer(Model<Integer> model, Model<Integer> mancalaPitModel){
        for(int i=0;i<12;i++){
            pitSaveState.add(model.get(i));
        }

        for(int i = 0;i <2; i++){
            mancalaPitSaveState.add(mancalaPitModel.get(i));
        }
    }

    /**
     * This static method updates the save states.
     * @param model the model used to hold the beads in the mancala pits
     * @param mancalaPitModel the board containing all the pits
     */
    public static void update(Model<Integer> model, Model<Integer> mancalaPitModel){
        isDisabled = false;
        for(int i=0;i<12;i++){
            pitSaveState.update(i, model.get(i));
        }

        for(int i = 0;i <2; i++){
            mancalaPitSaveState.update(i, mancalaPitModel.get(i));
        }
    }

}




