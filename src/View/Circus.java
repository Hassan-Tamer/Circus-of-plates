package View;

import Controller.Admin;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

import java.util.LinkedList;
import java.util.List;
import Model.*;

public class Circus implements World{
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private Life Lives;
    private int SPEED;
    private final int width,height;
    private Clown clown;
    private final Admin admin;
    private static final int CLOWNSPEED = 20;
    private Shelf rightShelf;
    private Shelf leftShelf;
    private long startTime;
    private int score = 0;
    
    public Circus(int width, int height){
        this.width = width;
        this.height = height;
        init();
        admin = new Admin(this);
    }
    
    private Circus(Circus c){
        this.width = c.width;
        this.height = c.height;
        this.SPEED = c.getSpeed();
        init();
        admin = new Admin(this);
        admin.setShapeSpeed(c.getAdmin().getShapeSpeed());
        admin.setBOMBRATE(c.getAdmin().getBOMBRATE());
        admin.setFACTORYRATE(c.getAdmin().getFACTORYRATE());
    }
    
    private void init(){
        clown = Clown.getInstance((width/2) - 50, height-(259) - 18, "Clown2.png");
        rightShelf = new Shelf(800,50,"shelf.png",800);
        leftShelf = new Shelf(0,50,"shelf.png",300);
        ImageObject BackGround =  new ImageObject(0,30,"back.png","back2.png");
        constant.add(BackGround);
        control.add(clown);
        constant.add(rightShelf);
        constant.add(leftShelf);
        Lives = new Life();
        Lives.updateLives(this,2);
        startTime = System.currentTimeMillis();
    }
    public Circus clone(){
        return new Circus(this);
        }
    @Override
    public boolean refresh() {
         admin.refresh(this);
         return true;
    }

    @Override
    public String getStatus() {
        return "Score = " + score+ "   ||   Lives = " + Lives.getCurrentLives() +"   || Difficulty : " + getDifficulty();
    }

    private String getDifficulty()
    {
        return switch (SPEED) {
                case 13 -> "Easy";
                case 9 -> "Medium";
                case 5 -> "Hard";
                default -> "unknown";
    };}
    @Override
    public int getSpeed() {
        return SPEED;
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
    public Clown getClown() {
        return clown;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void SetSPEED(int x){
        SPEED= x;
    }
    public int getScore() {
        return score;
    }
    public void addPoint(){
        score++;
    }

    public Life getLives() {
        return Lives;
    }
    

}