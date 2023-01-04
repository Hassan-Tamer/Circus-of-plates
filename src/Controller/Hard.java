package Controller;

import View.Circus;

public class Hard implements Strategy{
    private static Hard INSTANCE;
    public static Hard getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Hard();
        }
        return INSTANCE;
    }
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(5);
        c2.getAdmin().setShapeSpeed(3);
        c2.getAdmin().setBOMBRATE(2000);
        c2.getAdmin().setFACTORYRATE(500);
        return c2;
        // change speed 
        // drop boombs more frequently
    }
}
