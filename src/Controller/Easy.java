package Controller;

import View.Circus;

public class Easy implements Strategy{
    @Override
    public void changeDifficulty(Circus c) {
        c.setShapeSpeed(100);
    }
}
