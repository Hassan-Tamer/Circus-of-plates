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
    private final Stick LeftStick = new Stick();
    private final Stick RightStick = new Stick();
    private final GameObject clown;

    public Admin(Circus c){
        this.clown = c.getControlableObjects().get(0);
    }
//    public void AddCollectable(ImageObject image){
//        collectables.add(image);
//    }

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
    public boolean refresh(Circus c){
        Stack<Shape> leftCollectables = LeftStick.getCollectables();
        Stack<Shape> rightCollectables = RightStick.getCollectables();
        for(int i=0;i<c.getMovableObjects().size();i++){
            Shape shape = (Shape) c.getMovableObjects().get(i);

            int leftHeight = LeftStick.intersectionHeight(shape);
            int rightHeight = RightStick.intersectionHeight(shape);

            if(!isIntersected(shape,clown,leftHeight,rightHeight)){
                shape.setY(shape.getY() + 1);
            }
            else{
                shape.setStick(true);
                c.getMovableObjects().remove(shape);
                c.getControlableObjects().add(shape);
                if(leftIntersect(shape,clown,leftHeight)){
                    leftCollectables.push(shape);

                }
                else if(rightIntersect(shape,clown,rightHeight)) {
                    rightCollectables.push(shape);
                }
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

// NOT SURE ABOUT THESE NUMBERS YET
// ****The difference in height between 2 plates is 15
// ****If plate then pie [Aw el 3aks Not sure]  the difference in height is 35


/*
@TODO

 Add y as an attribute where y is calculated based on the stick's stack and the type of shape [plate , pie = 1,2]
 */