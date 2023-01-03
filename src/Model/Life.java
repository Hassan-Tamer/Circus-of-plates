package Model;

import View.Circus;

public class Life {
    private int currentLives = 2;
    private static String defaultPath = "Assets\\life.png";

    public void updateLives(Circus circus,int Lives){
        for(int i = 0; i < Lives; i++)
            circus.getConstantObjects().add(new ImageObject(21*i + circus.getWidth()/2,0,defaultPath));

        currentLives = Lives;
    }

    public void updateLives(Circus circus){
        for(int i = 0; i < currentLives; i++)
            circus.getConstantObjects().add(new ImageObject(21*i + circus.getWidth()/2,0,defaultPath));

    }

    public boolean loseALive(Circus c){
        if(currentLives>1){
            c.getConstantObjects().remove(c.getConstantObjects().size()-1);
            currentLives--;
            return true;
        }
        else{
            c.getConstantObjects().remove(c.getConstantObjects().size()-1);
            currentLives--;
            return false;
        }
        
    }

    public int getCurrentLives() {
        return currentLives;
    }
    
}
