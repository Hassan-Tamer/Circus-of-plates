package View;

import Controller.Admin;
import Controller.ImageObjectFactory;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.LinkedList;
import java.util.List;
//plate 70*22
import Model.*;

public final class Circus implements World{
    private static Circus INSTANCE;
    private final List<GameObject> constant = new LinkedList<GameObject>(); //theme
    private final List<GameObject> moving = new LinkedList<GameObject>();   //plates , pies
    private final List<GameObject> control = new LinkedList<GameObject>();  //clown
    private static int LIVES = 5;
    private final int width,height;
    public Clown getClown() {
        return clown;
    }

    private Clown clown;

    public Admin getAdmin() {
        return admin;
    }

    private final Admin admin;
    private static final int CLOWNSPEED = 10;
    private Shelf rightShelf;
    private Shelf leftShelf;
    private long startTime;
    private Circus(int width, int height){
        this.width = width;
        this.height = height;
        init();
        admin = new Admin(this);
//        backgroundMusic();
    }

    private void init(){
        clown = Clown.getInstance((width/2) - 50, height-(259) - 18, "Assets\\Clown2.png");
        rightShelf = new Shelf(800,50,"Assets\\shelf.png",800);
        leftShelf = new Shelf(0,50,"Assets\\shelf.png",300);
        ImageObject BackGround =  new ImageObject(0,30,"Assets\\back.png","Assets\\back2.png");
        constant.add(BackGround);
        control.add(clown);
        constant.add(rightShelf);
        constant.add(leftShelf);
        updateLives();
        startTime = System.currentTimeMillis();
    }

    public void loseALive(){
        if(LIVES>1){
            constant.remove(constant.size()-1);
            LIVES--;
        }
        else{
            control.remove(clown);// hina mi7tageen clone 34an ne initialize el crying clown with the same coordinates as the original clown
        }
    }
    private void updateLives(){
        for(int i = 0; i < LIVES; i++){
            constant.add(new ImageObject(21*i + width/2,0,"Assets\\life.png"));
        }
    }
    private void backgroundMusic(){
        Music intro = new Music("Assets\\tadaa.wav");
        intro.playSound();
        Music backMusic = new Music("Assets\\circus.wav");
        backMusic.start();
    }

    public static Circus getInstance(int width, int height){
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
        return "Score = " + ((Clown)getControlableObjects().get(0)).getScore() + "   ||   Lives = " + LIVES;
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

    public Shelf getRightShelf() {
        return rightShelf;
    }

    public Shelf getLeftShelf() {
        return leftShelf;
    }

}