package Model;

import Controller.Admin;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.io.IOException;

public abstract class Shape extends ImageObject{
    private int shapeHeight;
    private int shapeWidth ;
    public int getColor() {
        return color;
    }
    private final int color;        //red , green , blue , invalid  --> 1,2,3,-1
    private final Circus circus; // 3awez an2el el circus beta3 el admin hina
    public Shape(int x, int y, String path, Admin admin){
        super(x, y, path);
        color = pathSplitter(path);
        //circus = Circus.getInstance(1100,600);
        circus = admin.getCircus();
    }
    private int pathSplitter(String path) {
        String[] s = path.split("_");
        try {
            return switch (s[1]) {
                case "red.png" -> 1;
                case "green.png" -> 2;
                case "blue.png" -> 3;
                default -> -1;
            };
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    @Override
    public void setX(int x) {
        GameObject clown = circus.getClown();
        if((this.getX() > 310 && this.getX() < 730) && circus.getMovableObjects().contains(this))
            return;
        
        if(circus.getAdmin().getLeftStick().getCollectedShapes().contains(this)  && x >= circus.getWidth() - clown.getWidth())
            return;

        if(circus.getAdmin().getRightStick().getCollectedShapes().contains(this) && x <= clown.getWidth()-55)
            return;

        super.setX(x);
        }


    @Override
    public void setY(int y) {
        Shelf shelfL = circus.getLeftShelf();
        Shelf shelfR = circus.getRightShelf();

        if(circus.getControlableObjects().contains(this)){
            return;
        }

        if(this instanceof Bomb)
            super.setY(y);


        else if((this.getX() >= shelfL.getFallingPosition() && this.getX() <= shelfR.getFallingPosition()))
            super.setY(y);

    }

    public abstract int Getdelta();
    public abstract int Getdy();
    public int getShapeHeight(){
        return shapeHeight;
    }

    public int getShapeWidth(){
        return shapeWidth;
    }

    public void setShapeHeight(int shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    public void setShapeWidth(int shapeWidth) {
        this.shapeWidth = shapeWidth;
    }
}
