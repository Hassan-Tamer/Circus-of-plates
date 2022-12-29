package Controller;

import Model.Clown;
import Model.ImageObject;
import Model.Pie;
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
    private long prevTime = 0;
    private ShapeGenerator rand;
    private int TOPSTICK;
    private static final int FACTORYRATE = 1000;
    private int Margin = 10; // can change with difficulty for more accuracy 
    
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
        long current = clock.millis();
        boolean removedShapes = false;
       for(int i=0;i<c.getMovableObjects().size();i++){
           Shape shapec = (Shape) c.getMovableObjects().get(i);

           if(isIntersected(shapec , clown)){
               if(leftIntersect(shapec,clown)){
                   System.out.println("intersected");
                   int yMin = LeftStick.getyMin();
                   LeftStick.addCollectedShape(shapec);
                   if(shapec instanceof Pie){
                    shapec.setY(shapec.getY() - 30);} 
                   removedShapes =removeLastThree(LeftStick,c);
               }else if(rightIntersect(shapec,clown)){
                   int yMin = RightStick.getyMin();
                   RightStick.addCollectedShape(shapec);
                   if(shapec instanceof Pie){
                    shapec.setY(shapec.getY() - 30);}
                   removedShapes =removeLastThree(RightStick,c);
               }
               c.getMovableObjects().remove(shapec);
               if(!removedShapes) c.getControlableObjects().add(shapec);
                }
           else if(shapec.getY() > c.getHeight())
               c.getMovableObjects().remove(shapec);

       }
        if(current - prevTime > FACTORYRATE){
            c.getMovableObjects().add(rand.randomGenerator());
            prevTime = current;
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
        return true;
    }
    private boolean removeLastThree(Stick stick,Circus c){

        int size = stick.getCollectedShapes().size();
        if(size >= 3) {
            if(stick.getCollectedShapes().get(size-1).getColor() == stick.getCollectedShapes().get(size-2).getColor() && stick.getCollectedShapes().get(size-2).getColor() == stick.getCollectedShapes().get(size-3).getColor())
            {
                System.out.println("in first element " + c.getControlableObjects().remove(stick.removeCollectedShape(size-1)));
                c.getControlableObjects().remove(stick.removeCollectedShape(size-2));
                c.getControlableObjects().remove(stick.removeCollectedShape(size-3));
                ((Clown)clown).addPoint();
                return true;
            }
        }
        return false;

    }
}