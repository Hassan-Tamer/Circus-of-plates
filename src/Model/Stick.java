package Model;

import java.util.ArrayList;

public class Stick {
     private int yMin;
     private int yMax;
     private ArrayList<Shape> collectedShapes= new ArrayList<>();
     public Stick() {
         this.yMax=259;
         this.yMin=397;
     }
     public int getyMin(){
         return this.yMin;
     }

     public int getyMax(){
         return this.yMax;
     }

     public void setyMin(int x){
         this.yMin=x;
     }

     public ArrayList<Shape> getCollectedShapes(){
         return this.collectedShapes;
     }

     public void addCollectedShape(Shape shape){
         collectedShapes.add(shape);
         if(shape instanceof Plate){
             yMin=yMin-15;
         }
         if(shape instanceof Pie){
             yMin=yMin-35;
         }
     }
    public Shape removeCollectedShape(int index){
        Shape shape = collectedShapes.get(index);
        if(shape instanceof Plate){
            yMin=yMin+15;
        }
        if(shape instanceof Pie){
            yMin=yMin+35;
        }
        return collectedShapes.remove(index);
    }
     public boolean isFull(){
         return yMin == yMax;
     }

}
