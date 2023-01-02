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
        CryingClown cryingClown= new CryingClown(this.getCircus().getClown().getX(),this.getCircus().getHeight()/2 + 50);
        this.getCircus().getControlableObjects().clear();
        this.getCircus().getControlableObjects().add(cryingClown);

    }

    public boolean getState(){
        return false;
    }

}
