package Controller;

import View.Circus;
import eg.edu.alexu.csd.oop.game.World;

public class Easy implements Strategy{
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(1);
        c2.getAdmin().setBOMBRATE(9900);
        c2.getAdmin().setFACTORYRATE(1500);        
        return c2;
    }
}
