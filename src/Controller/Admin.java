package Controller;

import Model.ImageObject;
import Model.Shape;
import Model.Stick;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.time.*;

public class Admin {
    private ArrayList<ImageObject> collectables= new ArrayList<>();
    private int Difficulty;
    private final Stick LeftStick = new Stick();
    private final Stick RightStick = new Stick();
    private final GameObject clown;
    private Clock clock;
    private int shapeSpeed = 1;
    private long prevTime = 0;
    private ShapeGenerator rand;
    private static final int TOPSTICK = 5;
    private static final int FACTORYRATE = 1000;

    public Admin(Circus c){
        this.clown = c.getControlableObjects().get(0);
        clock = Clock.systemDefaultZone();
        rand = new ShapeGenerator();
    }


    private boolean leftIntersect(GameObject o , GameObject clown){
        int y = TOPSTICK;
        int netX = clown.getX() - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40;
        boolean inRangeY = netY == y;
        return inRangeX && inRangeY;
    }

    private boolean rightIntersect(GameObject o , GameObject clown){
        int y = TOPSTICK;
        int netX = clown.getX() + clown.getWidth() - 60 - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40 ;
        boolean inRangeY = netY == y;
        return inRangeX && inRangeY;
    }

    private boolean isIntersected(GameObject o , GameObject clown){
        return rightIntersect(o,clown) || leftIntersect(o,clown);
    }

    public boolean refresh(Circus c){
        long current = clock.millis();
       for(int i=0;i<c.getMovableObjects().size();i++){
           Shape shapec = (Shape) c.getMovableObjects().get(i);

           if(isIntersected(shapec , clown)){

               if(leftIntersect(shapec,clown)){
                   int yMin = LeftStick.getyMin();
                   LeftStick.addCollectedShape(shapec);
                   shapec.setY(shapec.getY() + yMin);
               }else if(rightIntersect(shapec,clown)){
                   int yMin = LeftStick.getyMin();
                   RightStick.addCollectedShape(shapec);
                   shapec.setY(shapec.getY() + yMin);
               }
               c.getMovableObjects().remove(shapec);
               c.getControlableObjects().add(shapec);
                }
       }
        if(current - prevTime > FACTORYRATE){
            c.getMovableObjects().add(rand.randomGenerator());
            prevTime = current;
        }
        for(GameObject shape : c.getMovableObjects()){
            if(shape.getX() < 290)
                shape.setX(shape.getX() + shapeSpeed);
            else if(shape.getX() > 720)
                shape.setX(shape.getX() - shapeSpeed);
            if(shape.getX()>=290&&shape.getX()<=720){
                shape.setY(shape.getY() + shapeSpeed);
            }
        }
        return true;
    }
}