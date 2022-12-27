package View;

import Controller.Admin;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.LinkedList;
import java.util.List;

import Model.*;
public final class Circus implements World{
    private static Circus INSTANCE;
    private final List<GameObject> constant = new LinkedList<GameObject>(); //theme
    private final List<GameObject> moving = new LinkedList<GameObject>();   //plates
    private final List<GameObject> control = new LinkedList<GameObject>();  //clown
    private final int width,height;
    private Admin admin = new Admin();
    private int ShapeSpeed = 10;    //The higher, the slower
    private Circus(int width, int height){
        this.width = width;
        this.height = height;
        constant.add(new ImageObject(0,30,"Assets\\back.png"));

        Clown clown = Clown.getInstance((width/2) - 50, (int)(height*0.6), "Assets\\Clown2.png");
        control.add(clown);
//        moving.add(new ImageObject(clown.getX(), clown.getY()-200,"Assets\\pie_blue.png"));
        moving.add(new ImageObject(500 ,90, "Assets\\plate_blue.png"));

        constant.add(new ImageObject(0,30,"Assets\\shelf.png"));
        constant.add(new ImageObject(800,30,"Assets\\shelf.png"));
    }

    public static Circus getInstance(int width, int height) {
        if(INSTANCE == null) {
            INSTANCE = new Circus(width,height);
        }

        return INSTANCE;
    }
    @Override
    public boolean refresh() {
        GameObject o = moving.get(0);
        o.setY(o.getY() + 1);
//        if(!leftIntersect(o, control.get(0)) && !rightIntersect(o,control.get(0)))
//            o.setY(o.getY() + 1);
//        else{
//            System.out.println("inter");
//        }


        return true;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public int getSpeed() {
//        return ShapeSpeed;
        return 50;
    }

    @Override
    public int getControlSpeed() {
        return 10;
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
    public int getShapeSpeed() {
        return ShapeSpeed;
    }
    public void setShapeSpeed(int ShapeSpeed){
        this.ShapeSpeed = ShapeSpeed;
    }

}