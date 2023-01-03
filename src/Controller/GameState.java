package Controller;

import View.Circus;

public abstract class GameState {

    private Circus circus;
    private boolean state;

    public GameState(Circus c){
        this.circus =c;
        
    }

    public void setState(boolean state){
        this.state=state;
    }
    public Circus getCircus(){
        return this.circus;
    }

    public boolean getState(){
        return this.state;
    }

    public abstract void gameAction();



}
