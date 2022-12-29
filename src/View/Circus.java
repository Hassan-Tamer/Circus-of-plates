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
    private static final int CLOWNSPEED = 10;
    private Circus(int width, int height){
        this.width = width;
        this.height = height;
        constant.add(new ImageObject(0,30,"Assets\\back.png"));
        Clown clown = Clown.getInstance((width/2) - 50, (int)(height*0.63), "Assets\\Clown2.png");
        control.add(clown);
        constant.add(new ImageObject(0,30,"Assets\\shelf.png"));
        constant.add(new ImageObject(800,30,"Assets\\shelf.png"));
        admin = new Admin(this);
        Music hassan = new Music("Assets\\tadaa.wav");
        hassan.playSound();
        Music yassin = new Music("Assets\\circus.wav");
        yassin.start();
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
        return 10;
    }

    @Override
    public int getControlSpeed() {
        return CLOWNSPEED;
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