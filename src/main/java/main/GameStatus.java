package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameStatus extends JPanel {
    Model<Integer> beadsModel;
    MancalaBoard board;

    public GameStatus(Model<Integer> model, MancalaBoard board){
        beadsModel = model;
        this.board = board;
        add(createMenuBar());
    }




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

        gameBoardOptions.add(defaultMode);
        gameBoardOptions.add(darkMode);


        return bar;
    }


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



    private ActionListener setBeads(int beads){
        return e->{
            for(int i=0; i<12; i++){
                beadsModel.update(i, beads);
            }
        };
    }

    private ActionListener setBoardOptions(BoardStyle picker){
       return e -> {
           this.board.setStyle(picker);
       };

    }







    }