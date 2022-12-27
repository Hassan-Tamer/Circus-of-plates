package Controller;

import Model.ImageObject;
import Model.Shape;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.ArrayList;
import java.util.Stack;

public class Admin {
    private ArrayList<ImageObject> collectables= new ArrayList<>();
    private int Difficulty;
    private Stick LeftStick = new Stick();
    private Stick RightStick = new Stick();
    private int y;
    private int ClownSpeed;
    private GameObject clown;
    private int prev;
    public Admin(Circus c){
        ClownSpeed = c.getClownSpeed();
        this.clown = c.getControlableObjects().get(0);
        prev = clown.getX();
    }
    public void AddCollectable(ImageObject image){
        collectables.add(image);
    }

    private boolean leftIntersect(GameObject o , GameObject clown , int y){
        int netX = clown.getX() - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40;
        boolean inRangeY = netY == y;
        return inRangeX && inRangeY;
    }

    private boolean rightIntersect(GameObject o , GameObject clown, int y){
        int netX = clown.getX() + clown.getWidth() - 60 - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40 ;
        boolean inRangeY = netY == y;
        return inRangeX && inRangeY;
    }

    private boolean isIntersected(GameObject o , GameObject clown,int yleft , int yright){
        return rightIntersect(o,clown,yright) || leftIntersect(o,clown,yleft);
    }
    private void catchShape(Shape shape){
        int current = clown.getX();
        if(current!=prev){
            if(current < prev)
                shape.setX(shape.getX() - ClownSpeed);
            else
                shape.setX(shape.getX() + ClownSpeed);
            prev = current;
        }
        shape.setStick(true);
    }
    public boolean refresh(Circus c){
        Stack<Shape> leftCollectables = LeftStick.getCollectables();
        Stack<Shape> rightCollectables = RightStick.getCollectables();
        for(int i=0;i<c.getMovableObjects().size();i++){
            Shape plate = (Shape) c.getMovableObjects().get(i);

            int leftHeight = LeftStick.intersectionHeight(plate);
            int rightHeight = RightStick.intersectionHeight(plate);

            if(!isIntersected(plate,clown,leftHeight,rightHeight)){
                plate.setY(plate.getY() + 1);
            }
            else{
                catchShape(plate);
                if(leftIntersect(plate,clown,leftHeight)){
                    leftCollectables.push(plate);
                }
                else
                    rightCollectables.push(plate);
            }
        }


        return true;
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

// in intersection :
// **** for plates @ y = -55 --> the bottom of the stick
// ****for pies @ y = -40 --> the bottom of the stick

// NOT SURE ABOUT THESE NUMBER YET
// ****The difference in height between 2 plates is 15
// ****If plate then pie [Aw el 3aks Not sure]  the difference in height is 35


/*
@TODO

 Add y as an attribute where y is calculated based on the stick's stack and the type of shape [plate , pie = 1,2]
 */