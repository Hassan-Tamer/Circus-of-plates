package Controller;

import View.Circus;

public class Medium implements Strategy{
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(9);
        c2.getAdmin().setShapeSpeed(1);
        c2.getAdmin().setBOMBRATE(2500);
        c2.getAdmin().setFACTORYRATE(1000);
        return c2;
    }
}
