package Controller;

import Model.*;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;


import java.util.ArrayList;
import java.time.*;

public class Admin {
    private ArrayList<ImageObject> collectables= new ArrayList<>();
    private final Stick LeftStick = new Stick();

    public Stick getLeftStick() {
        return LeftStick;
    }

    public Stick getRightStick() {
        return RightStick;
    }

    private final Stick RightStick = new Stick();
    private final GameObject clown;
    private Clock clock;
    private int shapeSpeed = 1;
    private long prevTimeFactory = 0;
    private long prevTimeBomb = 0;
    private ShapeGenerator rand;
    private int TOPSTICK;
    private int FACTORYRATE = 1000;
    private int BOMBRATE = 4000;
    private int Margin = 10; // can change with difficulty for more accuracy
    private boolean gameOver = true;
    
    public Admin(Circus c){
        this.clown = c.getControlableObjects().get(0);
        clock = Clock.systemDefaultZone();
        rand = new ShapeGenerator();
        TOPSTICK = clown.getY()+70;
    }


    private boolean leftIntersect(GameObject o , GameObject clown){
        int y = LeftStick.getyMin();
        int netX = clown.getX() - o.getX();
        int netY = y - o.getY();
        boolean inRangeX = netX<=Margin && netX>=((-1)*Margin);
        boolean inRangeY = netY == 0;
        return inRangeX && inRangeY;
    }

    private boolean rightIntersect(GameObject o , GameObject clown){
        int y = RightStick.getyMin();
        int netX = clown.getX() + clown.getWidth() - 55 - o.getX();
        int netY = y - o.getY();
        boolean inRangeX = netX<=Margin && netX>=((-1)*Margin);
        boolean inRangeY = netY == 0;
        return inRangeX && inRangeY;
    }

    private boolean isIntersected(GameObject o , GameObject clown){
        return rightIntersect(o,clown) || leftIntersect(o,clown);
    }
    public boolean refresh(Circus c){
        long currentFactory = clock.millis();
        long currentFactoryBomb = clock.millis();
        boolean removedShapes = false, Full = false;
       for(int i=0;i<c.getMovableObjects().size();i++){
           Shape shapec = (Shape) c.getMovableObjects().get(i);

           if(shapec instanceof Bomb){
                   if(Bomb.BombStriked(shapec, clown)){
                        c.getMovableObjects().remove(shapec);
                       gameOver= Life.loseALive(c);
                   }
               }
           if(isIntersected(shapec , clown)){

                if(leftIntersect(shapec,clown)){
                   int yMin = LeftStick.getyMin();
                   LeftStick.addCollectedShape(shapec);
                   if(shapec instanceof Pie){
                   shapec.setY(shapec.getY() - 30);}
                   removedShapes =removeLastThree(LeftStick,c);
                   //Full = LeftStick.getCollectedShapes().size() == 6 ; 
                   /*if(Full){
                       c.loseALive();
                       for(int z = 0; i < 6; i++){
                           c.getControlableObjects().remove(LeftStick.removeCollectedShape(z));
                       }
                       LeftStick.setyMin(440);
                       continue;
                   }*/
               }else if(rightIntersect(shapec,clown)){
                   int yMin = RightStick.getyMin();
                   RightStick.addCollectedShape(shapec);
                   if(shapec instanceof Pie){
                    shapec.setY(shapec.getY() - 30);}
                   removedShapes =removeLastThree(RightStick,c);
               }
               c.getMovableObjects().remove(shapec); //starting from here
               if(!removedShapes)
                   c.getControlableObjects().add(shapec);
                }
           else if(shapec.getY() > c.getHeight())
               c.getMovableObjects().remove(shapec);

       }
        if(currentFactory - prevTimeFactory > FACTORYRATE){
            c.getMovableObjects().add(rand.randomGenerator());
            prevTimeFactory = currentFactory;
        }

        if(currentFactoryBomb - prevTimeBomb > BOMBRATE){
            c.getMovableObjects().add(rand.randomObstacle());
            prevTimeBomb = currentFactoryBomb;
        }

        for(GameObject shape : c.getMovableObjects()){

            if(shape.getX() < c.getLeftShelf().getFallingPosition()+10)
                shape.setX(shape.getX() + shapeSpeed);
            else if(shape.getX() > c.getRightShelf().getFallingPosition()-70)
                shape.setX(shape.getX() - shapeSpeed);
            if(shape.getX()>=c.getLeftShelf().getFallingPosition()+10&&shape.getX()<=c.getRightShelf().getFallingPosition()-70){
                shape.setY(shape.getY() + shapeSpeed);
            }

        }
        return gameOver;
    }
    private boolean removeLastThree(Stick stick,Circus c){

        int size = stick.getCollectedShapes().size();
        if(size >= 3) {
            if(stick.getCollectedShapes().get(size-1).getColor() == stick.getCollectedShapes().get(size-2).getColor() && stick.getCollectedShapes().get(size-2).getColor() == stick.getCollectedShapes().get(size-3).getColor())
            {
                c.getControlableObjects().remove(stick.removeCollectedShape(size-1));
                c.getControlableObjects().remove(stick.removeCollectedShape(size-2));
                c.getControlableObjects().remove(stick.removeCollectedShape(size-3));
                ((Clown)clown).addPoint();
                return true;
            }
        }
        return false;
    }

    public void setFACTORYRATE(int FACTORYRATE) {
        this.FACTORYRATE = FACTORYRATE;
    }

    public void setBOMBRATE(int BOMBRATE) {
        this.BOMBRATE = BOMBRATE;
    }
}