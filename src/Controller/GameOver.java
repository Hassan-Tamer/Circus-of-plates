package Controller;

import Model.CryingClown;
import Model.ImageObject;
import Model.Music;
import View.Circus;

public class GameOver extends GameState{

    private boolean lost = true;

    public GameOver(Circus c) {
        super(c);
    }


    public void gameAction() {
        this.getCircus().getConstantObjects().add(new ImageObject(400, 300, "game_over.png"));
        this.getCircus().getControlableObjects().clear();
        CryingClown cryingClown= new CryingClown(this.getCircus().getClown().getX(),this.getCircus().getHeight()/2 + 50);
        this.getCircus().getControlableObjects().add(cryingClown);
        Music gameOver = new Music("Assets\\gameover.wav");
        if(lost){
            gameOver.start();
            lost = false;

        }

    }

    public boolean getState(){
        return false;
    }

}
