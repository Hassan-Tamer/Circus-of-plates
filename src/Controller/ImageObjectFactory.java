package Controller;

import Model.ImageObject;
import Model.Pie;
import Model.Plate;
import Model.Shape;

import java.util.ArrayList;

public class ImageObjectFactory {

    private ArrayList<String> Color = new ArrayList<>();
    public ImageObjectFactory(){
        Color.add("green");
        Color.add("blue");
        Color.add("red");
    }
    public Shape CreatImageObject(String type,String Position){
        int index = (int)(Math.random() * Color.size());

       if(type.equalsIgnoreCase("plate")&&Position.equalsIgnoreCase("left"))
           return new Plate(0,25,"Assets\\plate_"+Color.get(index)+".png");
       else if(type.equalsIgnoreCase("plate")&&Position.equalsIgnoreCase("right"))
           return new Plate(1025, 25, "Assets\\plate_" + Color.get(index) + ".png");
       else if(type.equalsIgnoreCase("pie")&&Position.equalsIgnoreCase("left"))
            return new Pie(0,5,"Assets\\pie_"+Color.get(index)+".png");
       else if(type.equalsIgnoreCase("pie")&&Position.equalsIgnoreCase("right"))
            return new Pie(1025,5,"Assets\\pie_"+Color.get(index)+".png");
      return null;
    }
    public ImageObject CreatBomb(){
        ImageObject Bomb = new ImageObject(0,0,"Assets\\bomb.png");
        return Bomb;
    }

}
