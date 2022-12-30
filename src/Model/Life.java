package Model;

import View.Circus;

public class Life {

    private static final int defaultLIVES = 5;
    private static int currentLives = defaultLIVES;
    private static String defaultPath = "Assets\\life.png";

    public static void updateLives(Circus circus,int Lives){
        for(int i = 0; i < Lives; i++)
            circus.getConstantObjects().add(new ImageObject(21*i + circus.getWidth()/2,0,defaultPath));

        currentLives = Lives;
    }

    public static void updateLives(Circus circus){
        for(int i = 0; i < defaultLIVES; i++)
            circus.getConstantObjects().add(new ImageObject(21*i + circus.getWidth()/2,0,defaultPath));

    }
    public static boolean loseALive(Circus circus){
        if(currentLives>1){
            circus.getConstantObjects().remove(circus.getConstantObjects().size()-1);
            currentLives--;
        }
        else{
            Clown mainClown = circus.getClown();
            CryingClown clown2 = new CryingClown(mainClown.getX(),mainClown.getY() + 30,"Assets\\crying clown.png");
            circus.getControlableObjects().clear();
            circus.getControlableObjects().add(clown2);
            return false;
        }
        return true;
    }
}
