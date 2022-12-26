package Object;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.ArrayList;
import java.util.List;

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
