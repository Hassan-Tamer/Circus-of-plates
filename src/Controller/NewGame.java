package Controller;

import View.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NewGame extends GameState{
    //private Admin admin;
    GameEngine.GameController gamectrl;

    public NewGame(Circus c, GameEngine.GameController gamectrl) {
        super(c.clone());
        this.gamectrl = gamectrl;
    }

    @Override
    public void gameAction() {
        Circus oldCirc = getCircus();
        //gamectrl.changeWorld(new Circus(1100,600));
        Strategy strategy = oldCirc.getStrategy();
       Context context = new Context(strategy);
       Circus circus = context.executeStrategy(strategy.changeDifficulty(oldCirc));
        gamectrl.changeWorld(circus);
    }



    @Override
    public boolean getState(){
        return true;
    }
}
