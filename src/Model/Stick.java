package Model;

import java.util.ArrayList;

public class Stick {
     private int yMin;
     private int yMax;
     private ArrayList<Shape> collectedShapes= new ArrayList<>();
     public Stick() {
         this.yMax=305;        //y of clown == y of clown + stick length since the y coordinate is top left
         this.yMin=440;         // y clown + stick length
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
         yMin=yMin-shape.Getdelta();
     }
    public Shape removeCollectedShape(int index){
        Shape shape = collectedShapes.get(index);
        yMin=yMin+shape.Getdelta();
        return collectedShapes.remove(index);
    }

     public boolean isFull(){
         //return collectedShapes.size() == 6;
         return yMin <= yMax;
     }

}
/*package Model;

import java.util.ArrayList;

public class Stick {
     private int yMin;
     private int yMax;
     private ArrayList<Shape> collectedShapes= new ArrayList<>();
     public Stick() {
         this.yMax=305;        //y of clown == y of clown + stick length since the y coordinate is top left
         this.yMin=440;         // y clown + stick length
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

     public void addCollectedShape(Shape shape,boolean gameOver){
         if(!gameOver)
             return;
         collectedShapes.add(shape);
         yMin=yMin-(shape instanceof Plate ? 20: 45);
         //yMin=yMin-shape.getHeight();
     }
    public Shape removeCollectedShape(int index){
        Shape shape = collectedShapes.get(index);
        yMin=yMin+(shape instanceof Plate ? 20: 45);
        //yMin=yMin+shape.getHeight();
        return collectedShapes.remove(index);
    }

     public boolean isFull(){
         //return collectedShapes.size() == 6;
         return yMin <= yMax;
     }

}*/