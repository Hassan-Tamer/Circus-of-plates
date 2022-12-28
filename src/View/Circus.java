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
    private final List<GameObject> moving = new LinkedList<GameObject>();   //plates , pies
    private final List<GameObject> control = new LinkedList<GameObject>();  //clown
    private final int width,height;
    private final Admin admin;
    private int ShapeSpeed = 10;    //The higher, the slower
    private int ClownSpeed = 10;
    private Circus(int width, int height){
        this.width = width;
        this.height = height;
        constant.add(new ImageObject(0,30,"Assets\\back.png"));

        Clown clown = Clown.getInstance((width/2) - 50, (int)(height*0.63), "Assets\\Clown2.png");
        control.add(clown);
        Plate plate = new Plate(490,350,"Assets\\plate_green.png");
//        Pie pie = new Pie(580,300,"Assets\\pie_green.png");
//        Pie pie2 = new Pie(580,100,"Assets\\pie_green.png");
        moving.add(plate);
//        moving.add(pie);
//        moving.add(pie2);
        constant.add(new ImageObject(0,30,"Assets\\shelf.png"));
        constant.add(new ImageObject(800,30,"Assets\\shelf.png"));
        admin = new Admin(this);
    }

    public static Circus getInstance(int width, int height) {
        if(INSTANCE == null) {
            INSTANCE = new Circus(width,height);
        }

        return INSTANCE;
    }
    @Override
    public boolean refresh() {
        return admin.refresh(this);
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public int getSpeed() {
        return ShapeSpeed;
    }

    @Override
    public int getControlSpeed() {
        return ClownSpeed;
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

    public int getClownSpeed(){
        return ClownSpeed;
    }

    public void setClownSpeed(int speed){
        this.ClownSpeed = speed;
    }

}