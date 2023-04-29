package main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Undo extends JMenuItem{

    private final Model<Integer> oldModel;
    private final Model<Integer> oldPitModel;


    public Undo(Model<Integer> model, Model<Integer> mancalaPitModel){
        setText("Undo");
        oldModel = new Model<>();
        oldPitModel = new Model<>();


        for(int i=0;i<12;i++){
            oldModel.add(model.get(i));
        }

        for(int i = 0;i <2; i++){
            oldPitModel.add(mancalaPitModel.get(i));
        }

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<12;i++){
                    model.update(i, oldModel.get(i));
                }
                for(int i = 0;i <2; i++){
                    mancalaPitModel.update(i, oldPitModel.get(i));
                }
            }
        });
    }



}
