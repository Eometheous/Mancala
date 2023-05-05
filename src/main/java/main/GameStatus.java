package main;

import main.styles.*;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The status menu bar is the way the user can initialize the board with how many Mancala beads they want to play the
 * game with. Another option that is possible within this is setting the color of the board and the style of the board
 * of the game. The user can select between 2, 3, or 4 beads to the start the game with.
 * @author Jeffrey Van
 * @version 1.0.0.230505
 */
public class GameStatus extends JPanel {
    private static boolean isPlayerBTurn = true;
    public static boolean started = false;
    Model<Integer> beadsModel;
    MancalaBoard board;
    Model<Integer> mancalaPitsModel;

    /**
     * Creates a menu bar with all the possible menu options, game options & board options.
     * @param model   the model used to hold the beads in the mancala pits
     * @param board    the board containing all the pits
     */
    public GameStatus(Model<Integer> model, MancalaBoard board, Model<Integer> mancalaPitsModel){
        beadsModel = model;
        this.mancalaPitsModel = mancalaPitsModel;
        this.board = board;
        Victory.initializer(model,mancalaPitsModel);
        add(createMenuBar());
    }

    /**
     * Method that creates and returns a JMenuBar that has all the options available that the user can select from.
     * @return menu bar that has all the options
     */
    private JMenuBar createMenuBar(){
        JMenuBar bar = new JMenuBar();
        JMenu gameOptions= new JMenu("Game Options");
        JMenu gameBoardOptions = new JMenu("Styles");

        bar.add(gameOptions);
        bar.add(gameBoardOptions);


        JMenuItem startGame = new JMenuItem("Start Game");
        gameOptions.add(startGame);
        startGame.addActionListener(e -> setBeadsOptions());


        JMenuItem undoItem = new JMenuItem("Undo");
        undoItem.addActionListener(e->Undo.undo(beadsModel, mancalaPitsModel));
        gameOptions.add(undoItem);

        JMenuItem defaultMode = new JMenuItem("Default Board");
        defaultMode.addActionListener(setBoardOptions(new DefaultBoardStyle()));

        JMenuItem darkMode = new JMenuItem("Dark Mode Board");
        darkMode.addActionListener(setBoardOptions(new DarkModeStyle()));

        JMenuItem kimStyle = new JMenuItem("Kim Board");
        kimStyle.addActionListener(setBoardOptions(new KimStyle()));

        JMenuItem valorantStyle = new JMenuItem("Valorant Board");
        valorantStyle.addActionListener(setBoardOptions(new ValorantStyle()));

        JMenuItem clownStyle = new JMenuItem("Clown Board");
        clownStyle.addActionListener(setBoardOptions(new ClownStyle()));

        JMenuItem patriotStyle = new JMenuItem("MURICA!");
        patriotStyle.addActionListener(setBoardOptions(new PatriotStyle()));

        gameBoardOptions.add(defaultMode);
        gameBoardOptions.add(darkMode);
        gameBoardOptions.add(kimStyle);
        gameBoardOptions.add(valorantStyle);
        gameBoardOptions.add(clownStyle);
        gameBoardOptions.add(patriotStyle);

        return bar;
    }

    /**
     * Method that makes the buttons and displays it for the user to be able to interact with. It then displays
     * the options in a JOptionPane.
     */
    private void setBeadsOptions(){
        JRadioButton twoBeads = new JRadioButton("Two Beads");
        JRadioButton threeBeads = new JRadioButton("Three Beads");
        JRadioButton fourBeads = new JRadioButton("Four Beads");

        JRadioButton playerB = new JRadioButton("Player B");
        JRadioButton playerA = new JRadioButton("Player A");

        ButtonGroup players = new ButtonGroup();
        players.add(playerB);
        players.add(playerA);

        playerB.addActionListener(setPlayer(true));
        playerA.addActionListener(setPlayer(false));

        twoBeads.addActionListener(setBeads(2));
        threeBeads.addActionListener(setBeads(3));
        fourBeads.addActionListener(setBeads(4));

        ButtonGroup group = new ButtonGroup();
        group.add(twoBeads);
        group.add(threeBeads);
        group.add(fourBeads);

        Object[] radioButtons = {twoBeads, threeBeads, fourBeads, "\nWhich player should start?", playerB,playerA};

        JOptionPane.showMessageDialog(this, radioButtons, "Game Starter", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Method that returns an action listener, it basically sets the player in the game options.
     * @param player a boolean that is true if it is player b, false if player a
     * @return e Actionlistener that sets the player turn.
     */
    private ActionListener setPlayer(boolean player){
        return e -> setPlayerBTurn(player);
    }

    /**
     * Method that returns an ActionListener
     * @param beads the amount of beads
     * @return actionlistener that updates the amount of beads in each pit
     */
    private ActionListener setBeads(int beads){
        return e->{
            Undo.initializer(beadsModel,mancalaPitsModel);
            for(int i=0; i<12; i++){
                beadsModel.update(i, beads);
            }
            mancalaPitsModel.update(0,0);
            mancalaPitsModel.update(1,0);
            started = true;
        };
    }

    /**
     * Method that returns an ActionListener
     * @param picker the amount of beads
     * @return actionlistener that updates the border style of the Mancala board.
     */
    private ActionListener setBoardOptions(BoardStyle picker){
        return e -> this.board.setStyle(picker);

    }

    /**
     * Checks if it is player B's turn
     * @author Jonathan Stewart Thomas
     * @return  true if player B's turn, false otherwise
     */
    public static boolean isPlayerBTurn() {
        return isPlayerBTurn;
    }

    /**
     * Updates whose turn it is
     * @author Jonathan Stewart Thomas
     */
    public static void updatePlayersTurn() {
        isPlayerBTurn = !isPlayerBTurn;
    }

    /**
     * Sets the turn to player B's turn
     * @author Jonathan Stewart Thomas
     * @param playersTurn   the boolean for player B's turn
     */
    public static void setPlayerBTurn(boolean playersTurn) {
        isPlayerBTurn = playersTurn;
    }

}