package Model;

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
    private final Circus circus;
    public Shape(int x, int y, String path){
        super(x, y, path);
        color = pathSplitter(path);
        circus = Circus.getInstance(1100,600);
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
        GameObject clown = circus.getControlableObjects().get(0);
        if((this.getX() > 310 && this.getX() < 730) && circus.getMovableObjects().contains(this) )
            return;

        if(circus.getAdmin().getLeftStick().getCollectedShapes().contains(this) && x > clown.getX() - 2)
            return;

        if(circus.getAdmin().getRightStick().getCollectedShapes().contains(this) && x < clown.getX() + clown.getWidth()/2)
            return;

        super.setX(x);
        }


    @Override
    public void setY(int y) {
        if(circus.getControlableObjects().contains(this)){
            return;
        }
        if((this.getX() >=310 && this.getX() <= 730))
            super.setY(y);
    }

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
