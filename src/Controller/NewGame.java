package Controller;

import Model.Music;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class NewGame extends GameState{
    //private Admin admin;
    GameEngine.GameController gamectrl;

    public NewGame(Circus c, GameEngine.GameController gamectrl) {
        super(c.clone());
        this.gamectrl = gamectrl;
    }

    @Override
    public void gameAction() {
        gamectrl.changeWorld(getCircus());
        Music newgame = new Music("Assets\\newgame.wav");
        newgame.start();
    }

    @Override
    public boolean getState(){
        return true;
    }
}
