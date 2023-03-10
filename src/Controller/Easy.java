package Controller;


import View.Circus;
public class Easy implements Strategy{
    private static Easy INSTANCE;
    public static Easy getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Easy();
        }
        return INSTANCE;
    }
    @Override
    public Circus changeDifficulty(Circus c) {
        Circus c2 = c.clone();
        c2.SetSPEED(13);
        c2.getAdmin().setShapeSpeed(1);
        c2.getAdmin().setBOMBRATE(6000);
        c2.getAdmin().setFACTORYRATE(1300);        
        return c2;
    }

}
