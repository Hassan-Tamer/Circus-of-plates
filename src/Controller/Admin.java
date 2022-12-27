package Controller;

import Model.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;

public class Admin {
    private ArrayList<ImageObject> collectables= new ArrayList<>();
    private int Difficulty;
    private Stick LeftStick;
    private Stick RightStick;
    public void AddCollectable(ImageObject image){
        collectables.add(image);
    }

    private boolean leftIntersect(GameObject o , GameObject clown){
        int netX = clown.getX() - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40 ;
        boolean inRangeY = netY == 30;
        return inRangeX && inRangeY;
    }

    private boolean rightIntersect(GameObject o , GameObject clown){
        int netX = clown.getX() + clown.getWidth() - 60 - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40 ;
        boolean inRangeY = netY == 30;
        return inRangeX && inRangeY;
    }

    public boolean isIntersected(GameObject o , GameObject clown){
        return rightIntersect(o,clown) && leftIntersect(o,clown);
    }
    public ImageObject randomGenerator(int index){
        int count =  (int) Math.floor(Math.random()*6);
        ImageObjectFactory newimage=new ImageObjectFactory();
       if(index==1){

        return newimage.CreatImageObject(count);}
       if(index==2){
           return newimage.CreatBomb();
       }

        return null;
    }
}
