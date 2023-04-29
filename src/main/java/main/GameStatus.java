package main;

import main.styles.*;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The status menu bar is the way the user can initialize the board with how many Mancala beads they want to play the
 * game with. Another option that is possible within this is setting the color of the board and the style of the board
 * of the game. The user can select between 2, 3, or 4 beads to the start the game with.
 * @author Jeffrey Van
 * @version 1.0.0.230428
 */



public class GameStatus extends JPanel {
    Model<Integer> beadsModel;
    MancalaBoard board;


    /**
     * Creates a menu bar with all the possible menu options, game options & board options.
     * @param model   the model used to hold the beads in the mancala pits
     * @param board    the board containing all the pits
     */
    public GameStatus(Model<Integer> model, MancalaBoard board){
        beadsModel = model;
        this.board = board;
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


        JMenuItem defaultMode = new JMenuItem("Default Board");
        defaultMode.addActionListener(setBoardOptions(new DefaultBoardStyle()));

        JMenuItem darkMode = new JMenuItem("Dark Mode Board");
        darkMode.addActionListener(setBoardOptions(new DarkModeStyle()));

        JMenuItem kimStyle = new JMenuItem("Kim Board");
        kimStyle.addActionListener(setBoardOptions(new KimStyle()));

        JMenuItem valorantStyle = new JMenuItem("Valorant Board");
        valorantStyle.addActionListener((setBoardOptions(new ValorantStyle())));

        gameBoardOptions.add(defaultMode);
        gameBoardOptions.add(darkMode);
        gameBoardOptions.add(kimStyle);
        gameBoardOptions.add(valorantStyle);

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

        twoBeads.addActionListener(setBeads(2));
        threeBeads.addActionListener(setBeads(3));
        fourBeads.addActionListener(setBeads(4));

        ButtonGroup group = new ButtonGroup();
        group.add(twoBeads);
        group.add(threeBeads);
        group.add(fourBeads);

        Object[] radioButtons = {twoBeads, threeBeads, fourBeads};


        JOptionPane.showMessageDialog(this, radioButtons);

    }


    /**
     * Method that returns an ActionListener
     * @param beads the amount of beads
     * @return actionlistener that updates the amount of beads in each pit
     */
    private ActionListener setBeads(int beads){
        return e->{
            for(int i=0; i<12; i++){
                beadsModel.update(i, beads);
            }
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





}