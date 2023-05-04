package main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Undo{

    private static final Model<Integer> oldModel = new Model<>();
    private static final Model<Integer> oldPitModel = new Model<>();

    public static void undoMethod(Model<Integer> model, Model<Integer> mancalaPitModel){
        for(int i=0;i<12;i++){
            oldModel.add(model.get(i));
        }

        for(int i = 0;i <2; i++){
            oldPitModel.add(mancalaPitModel.get(i));
        }



        for(int i=0;i<12;i++){
            model.update(i,oldModel.get(i));
        }

        for(int i = 0;i <2; i++){
            mancalaPitModel.update(i,oldPitModel.get(i));
        }



    }


    public static void undoUpdate(Model<Integer> model, Model<Integer> mancalaPitModel){

        for(int i=0;i<12;i++){
            oldModel.update(i, model.get(i));
        }

        for(int i = 0;i <2; i++){
            oldPitModel.update(i, mancalaPitModel.get(i));
        }

    }




    }




