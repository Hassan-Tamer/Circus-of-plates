package Controller;

import java.util.ArrayList;

public class ShapeFactory {

    public void CreatShapes(){
        ArrayList<Shapes> shapes = new ArrayList<>();
        shapes.add(new Shapes(0,0,"Assets\\pie_green.png"));
        shapes.add(new Shapes(0,0,"Assets\\pie_blue.png"));
        shapes.add(new Shapes(0,0,"Assets\\pie_red.png"));
        shapes.add(new Shapes(0,0,"Assets\\plate_red.png"));
        shapes.add(new Shapes(0,0,"Assets\\plate_blue.png"));
        shapes.add(new Shapes(0,0,"Assets\\plate_green.png"));
        int count =  (int) Math.floor(Math.random()*6);
    }

}
