package Controller;

import View.Circus;
import eg.edu.alexu.csd.oop.game.World;

public class Easy implements Strategy{
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(13);
        c2.getAdmin().setBOMBRATE(6000);
        c2.getAdmin().setFACTORYRATE(1300);        
        return c2;
    }
}
