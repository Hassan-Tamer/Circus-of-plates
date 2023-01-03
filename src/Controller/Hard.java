package Controller;

import View.Circus;

public class Hard implements Strategy{
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(5);
        c2.getAdmin().setShapeSpeed(3);
        c2.getAdmin().setBOMBRATE(1500);
        c2.getAdmin().setFACTORYRATE(500);
        return c2;
    }
}
