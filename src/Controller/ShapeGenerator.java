package Controller;

import Model.Shape;
import java.io.IOException;

public class ShapeGenerator {
    public Shape randomGenerator(){
        String[] type = {"plate" , "pie"};
        String[] position = {"left" , "right"};
        int count = (int)(Math.random() * type.length);
        int count2 = (int)(Math.random() * type.length);
        ImageObjectFactory newimage=new ImageObjectFactory();
        return newimage.CreatImageObject(type[count],position[count2]);
    }
}
