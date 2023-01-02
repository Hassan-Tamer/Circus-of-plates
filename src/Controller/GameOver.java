package Controller;

import Model.CryingClown;
import Model.ImageObject;
import Model.Shape;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

public class GameOver extends GameState{


    public GameOver(Circus c) {
        super(c);
    }


    public void gameAction() {
        this.getCircus().getConstantObjects().add(new ImageObject(400, 300, "Assets\\game_over.png"));
        this.getCircus().getControlableObjects().clear();
        CryingClown cryingClown= new CryingClown(this.getCircus().getWidth()/2,this.getCircus().getHeight()/2);
        this.getCircus().getControlableObjects().add(cryingClown);

    }

    public boolean getState(){
        return false;
    }

}
