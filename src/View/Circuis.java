package View;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.LinkedList;
import java.util.List;

import Model.*;

public class Circuis implements World {
    private final List<GameObject> constant = new LinkedList<GameObject>(); //theme
    private final List<GameObject> moving = new LinkedList<GameObject>();   //plates
    private final List<GameObject> control = new LinkedList<GameObject>();  //clown
    private final int width,height;




    public Circuis(int width,int height){
        this.width = width;
        this.height = height;
        constant.add(new ImageObject(0,30,"Assets\\back.png"));

        Clown clown = Clown.getInstance((width/2) - 50, (int)(height*0.6), "Assets\\Clown2.png");
        control.add(clown);
//        moving.add(new ImageObject(clown.getX(), clown.getY()-200,"Assets\\pie_blue.png"));
        moving.add(new ImageObject(500 ,90, "Assets\\plate_Blue.png"));

        constant.add(new ImageObject(0,30,"Assets\\shelf.png"));
        constant.add(new ImageObject(800,30,"Assets\\shelf.png"));
    }
    private boolean leftIntersect(GameObject o , GameObject clown){
        int netX = clown.getX() - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40 ;
        boolean inRangeY = netY == 30;
        return inRangeX && inRangeY;
    }

    private boolean rightIntersect(GameObject o , GameObject clown){
        int netX = clown.getX() + clown.getWidth() - 60 - o.getX();
        int netY = clown.getY() - o.getY();
        boolean inRangeX = netX >=0 && netX < 40 ;
        boolean inRangeY = netY == 30;
        return inRangeX && inRangeY;
    }

    @Override
    public boolean refresh() {
        GameObject o = moving.get(0);
        if(!leftIntersect(o, control.get(0)) && !rightIntersect(o,control.get(0)))
            o.setY(o.getY() + 1);
        else{
            System.out.println("inter");
        }

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
}
