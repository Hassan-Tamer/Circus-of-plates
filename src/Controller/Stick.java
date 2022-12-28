package Controller;

import Model.Pie;
import Model.Plate;
import Model.Shape;

import java.util.ArrayList;
import java.util.Stack;

public class Stick {
     private int yMin;
     private int yMax;
     private ArrayList<Shape> collectedShapes= new ArrayList<>();
     public Stick() {
         this.yMax=55;
         this.yMin=52;
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

     public boolean isFull(){
         return yMin == yMax;
     }

}
