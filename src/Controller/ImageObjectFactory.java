package Controller;

import Model.*;
import java.io.IOException;

import java.util.ArrayList;

public class ImageObjectFactory {

    private ArrayList<String> Color = new ArrayList<>();
    public ImageObjectFactory(){
        Color.add("green");
        Color.add("blue");
        Color.add("red");
    }
    public Shape CreatImageObject(String type,String Position,Admin a){
        int index = (int)(Math.random() * Color.size());

       if(type.equalsIgnoreCase("plate")&&Position.equalsIgnoreCase("left"))
           //return new Plate(0,29,"Assets\\plate_"+Color.get(index)+".png",a);
           return new Plate(0,29,"plate_"+Color.get(index)+".png",a);
       else if(type.equalsIgnoreCase("plate")&&Position.equalsIgnoreCase("right"))
           //return new Plate(1025, 29, "Assets\\plate_" + Color.get(index) + ".png",a);
           return new Plate(1025, 29, "plate_" + Color.get(index) + ".png",a);
       else if(type.equalsIgnoreCase("pie")&&Position.equalsIgnoreCase("left"))
            //return new Pie(0,3,"Assets\\pie_"+Color.get(index)+".png",a);
           return new Pie(0,3,"pie_"+Color.get(index)+".png",a);
       else if(type.equalsIgnoreCase("pie")&&Position.equalsIgnoreCase("right"))
            //return new Pie(1025,3,"Assets\\pie_"+Color.get(index)+".png",a);
           return new Pie(1025,3,"pie_"+Color.get(index)+".png",a);
      return null;
    }
    public ImageObject CreatBomb(Admin a) throws IOException{
        Integer[] variableX= {0,183,366,549,732,915};
        int index = (int)(Math.random() * 5);
        Bomb bomb = new Bomb(variableX[index],0,a);
        return bomb;
    }

}
