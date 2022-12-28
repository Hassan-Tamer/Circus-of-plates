package World;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Object.*;

public class Circuis implements World {
    private final List<GameObject> constant = new LinkedList<GameObject>(); //theme
    private final List<GameObject> moving = new LinkedList<GameObject>();   //plates
    private final List<GameObject> control = new LinkedList<GameObject>();  //clown
    private int width,height;


    public Circuis(int width,int height) throws InterruptedException {
        this.width = width;
        this.height = height;
        constant.add(new ImageObject(0,30,"Assets\\back.png"));

        Clown clown = Clown.getInstance((width/2) - 50, (int)(height*0.6), "Assets\\Clown3.png");
        control.add(clown);
        moving.add(new ImageObject(0,0,"Assets\\pie_blue.png"));
        moving.add(new ImageObject(50,0,"Assets\\plate_Blue.png"));

        constant.add(new ImageObject(0,30,"Assets\\shelf.png"));
        constant.add(new ImageObject(800,30,"Assets\\shelf.png"));
    }
    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        GameObject o = moving.get(0);
        GameObject o2 = moving.get(1);
        o.setY(o.getY()+1);

        o2.setY(o.getY()+1);
        return true;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public int getSpeed() {
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
}
