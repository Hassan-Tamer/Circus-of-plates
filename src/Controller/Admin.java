package Controller;

import Model.*;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;


import java.util.ArrayList;
import java.time.*;

public class Admin {
    private Circus circus;
    private ArrayList<ImageObject> collectables= new ArrayList<>();
    private final Stick LeftStick = new Stick();
    private final Stick RightStick = new Stick();
    private final GameObject clown;
    private Clock clock;
    private int shapeSpeed = 1;
    private long prevTimeFactory = 0;
    private long prevTimeBomb = 0;
    private ShapeGenerator rand;
    private int FACTORYRATE = 1000;
    private int BOMBRATE = 1000;
    private int Margin = 10; // can change with difficulty for more accuracy
    private GameState state=new DuringGame(this.getCircus());
    //private NewGame newg = new NewGame(this.getCircus(),this);


    public Admin(Circus c){
        this.clown = c.getControlableObjects().get(0);
        clock = Clock.systemDefaultZone();
        rand = new ShapeGenerator();
        circus = c;
    }
    public void setCircus (Circus cirque){
        this.circus=cirque;
    }

    private boolean leftIntersect(GameObject o , GameObject clown){
        int y = clown.getY();
        int netX = clown.getX() - o.getX();
        int netY = y - (o.getY()+o.getHeight()); // intersect from the top and set it to its y min immediately
        boolean inRangeX = netX<=Margin && netX>=((-1)*Margin);
        boolean inRangeY = netY == 0;
        return inRangeX && inRangeY;
        
    }

    private boolean rightIntersect(GameObject o , GameObject clown){
        int y = clown.getY();
        int netX = clown.getX() + clown.getWidth() - 55 - o.getX();
        int netY = y - (o.getY()+o.getHeight());
        boolean inRangeX = netX<=Margin && netX>=((-1)*Margin);
        boolean inRangeY = netY == 0;
        return inRangeX && inRangeY;
    }
    
    private boolean isIntersected(GameObject o , GameObject clown){
        return (rightIntersect(o,clown) || leftIntersect(o,clown)) && state.getState();
    }
    
    public boolean refresh(Circus c){

        state.gameAction();
       long currentFactory = clock.millis();
        long currentFactoryBomb = clock.millis();
        boolean removedShapes = false, Full = false;
        for(int i=0;i<c.getMovableObjects().size();i++){
            Shape shapec = (Shape) c.getMovableObjects().get(i);

           if(shapec instanceof Bomb){
               if(state.getState()){
                   if(ShapeHandle.BombStriked(shapec, clown)){
                        c.getMovableObjects().remove(shapec);
                        if(!Life.loseALive(c)){
                            state=new GameOver(this.getCircus());
                        }

                   }}
                   else if(shapec.getY() > c.getHeight())
                     c.getMovableObjects().remove(shapec);
                   continue;
               }
           if(isIntersected(shapec , clown)){
                if(leftIntersect(shapec,clown)){
                   int yMin = LeftStick.getyMin();
                   LeftStick.addCollectedShape(shapec);
                   shapec.setY(yMin-shapec.Getdy());
                   removedShapes =ShapeHandle.removeLastThree(LeftStick,c);
                   if(LeftStick.isFull()){
                       {
                           if(!Life.loseALive(c)){
                           state=new GameOver(this.getCircus());
                       }
                       }
                       for(GameObject g : LeftStick.getCollectedShapes()){
                           c.getControlableObjects().remove(g);
                       }
                       LeftStick.setyMin(440);
                       LeftStick.getCollectedShapes().clear();
                       continue;
                   }
               }else if(rightIntersect(shapec,clown)){
                   int yMin = RightStick.getyMin();
                   RightStick.addCollectedShape(shapec);
                   shapec.setY(yMin-shapec.Getdy());
                    removedShapes =ShapeHandle.removeLastThree(RightStick,c);
                    if(RightStick.isFull()){
                        {
                        if(!Life.loseALive(c)){
                            state=new GameOver(this.getCircus());
                        }
                        }
                       for(GameObject g : RightStick.getCollectedShapes()){
                        c.getControlableObjects().remove(g);
                       }
                        RightStick.setyMin(440);
                        RightStick.getCollectedShapes().clear();
                        continue;}
               }
               c.getMovableObjects().remove(shapec);
               if(!removedShapes)
                   c.getControlableObjects().add(shapec);
                }
                else if(shapec.getY() > c.getHeight())
                     c.getMovableObjects().remove(shapec);

       }
        if(currentFactory - prevTimeFactory > FACTORYRATE){
            c.getMovableObjects().add(rand.randomGenerator(this));
            prevTimeFactory = currentFactory;
        }
        if(currentFactoryBomb - prevTimeBomb > BOMBRATE){
            c.getMovableObjects().add(rand.randomObstacle(this));
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

        return true;
    }

    public void setFACTORYRATE(int FACTORYRATE) {
        this.FACTORYRATE = FACTORYRATE;
    }

    public void setBOMBRATE(int BOMBRATE) {
        this.BOMBRATE = BOMBRATE;
    }
        public Stick getLeftStick() {
        return LeftStick;
    }

    public Stick getRightStick() {
        return RightStick;
    }

    public Circus getCircus() {
        return circus;
    }
    
}