package Model;

import View.Circus;

public class Shape extends ImageObject{

    public int getColor() {
        return color;
    }
    private final int color;        //red , green , blue , invalid  --> 1,2,3,-1
    private Circus circus;
    public boolean isOnShelf() {
        return onShelf;
    }

    public void setOnShelf(boolean onShelf) {
        this.onShelf = onShelf;
    }

    //    private boolean isSticked = false;
    private boolean onShelf = true;
    public Shape(int x, int y, String path) {
        super(x, y, path);
        color = pathSplitter(path);
        circus = Circus.getInstance(1100,600);
    }
    private int pathSplitter(String path){
        String[] s = path.split("_");
        return switch (s[1]) {
            case "red.png" -> 1;
            case "green.png" -> 2;
            case "blue.png" -> 3;
            default -> -1;
        };
    }

    @Override
    public void setX(int x) {
        if((this.getX() > 250 && this.getX() < 400) && circus.getMovableObjects().contains(this) )
            return;

        super.setX(x);
        }


    @Override
    public void setY(int y) {
        if(circus.getControlableObjects().contains(this)){
            return;
        }
        super.setY(y);
    }
}
