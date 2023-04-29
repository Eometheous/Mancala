package main;

public class Mancala {
    private Model<Integer> mancalaPitModel;
    private Model<Integer> pitsModel;

    public Mancala(Model<Integer> mancalaPitModel, Model<Integer> pitsModel) {
        this.mancalaPitModel = mancalaPitModel;
        this.pitsModel = pitsModel;
    }

    public void pickUp(int pitNum) {
        int total = pitsModel.get(pitNum); // gets total num of stones
        pitsModel.update(pitNum, 0); // sets num of stones in this pit to be 0

        boolean crossed = false;
        boolean crossed2 = false;

        if(pitNum >= 0 && pitNum < 5) {
            pitNum++;
        }
        else if(pitNum > 5 && pitNum < 11) {
            pitNum++;
        }
        else if(pitNum == 5) {
            crossed = true;
        }
        else if(pitNum == 11) {
            crossed2 = true;
        }

        for(int i = 0; i < total; i++) {
            if(crossed == true) {
                int big = mancalaPitModel.get(0);
                big++;
                mancalaPitModel.update(0, big);
                pitNum = 6;
                crossed = false;
            }
            else if(crossed2 == true) {
                int big = mancalaPitModel.get(1);
                big++;
                mancalaPitModel.update(1, big);
                pitNum = 5;
                crossed2 = false;
            }
            else if(pitNum <= 5 && pitNum >= 0) {
                int updated = pitsModel.get(pitNum);
                updated++;
                pitsModel.update(pitNum, updated);
                if(pitNum == 5) {
                    crossed = true;
                }
                else {
                    pitNum++;
                }
            }
            else if(pitNum >= 6 && pitNum <= 11) {
                int updated = pitsModel.get(pitNum);
                updated++;
                pitsModel.update(pitNum, updated);
                if(pitNum == 11) {
                    crossed2 = true;
                }
                else {
                    pitNum++;
                }
            }
        }
    }
}
