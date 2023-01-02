package Controller;

import View.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class NewGame extends GameState{
    //private Admin admin;
    GameEngine.GameController gamectrl;

    public NewGame(Circus c, GameEngine.GameController gamectrl) {
        super(c);
        this.gamectrl = gamectrl;
    }

    @Override
    public void gameAction() {
        //this.admin.setCircus(new Circus(1100,600));
        gamectrl.changeWorld(new Circus(1100,600));
    }

    public boolean getState(){
        return true;
    }
}
