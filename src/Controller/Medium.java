package Controller;

import View.Circus;

public class Medium implements Strategy{
    @Override
    public void changeDifficulty(Circus c) {
        c.setShapeSpeed(20);
    }
}
