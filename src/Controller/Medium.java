package Controller;

import View.Circus;

public class Medium implements Strategy{
    private static Medium INSTANCE;
    public static Medium getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Medium();
        }
        return INSTANCE;
    }
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(9);
        c2.getAdmin().setShapeSpeed(2);
        c2.getAdmin().setBOMBRATE(5000);
        c2.getAdmin().setFACTORYRATE(1000);
        return c2;
    }
}
