package Model;

public class Shape extends ImageObject{

    public int getType() {
        return type;
    }

    public int getColor() {
        return color;
    }

    private final int type;         // plate , pie --> 1,2
    private final int color;        //red , green , blue , invalid  --> 1,2,3,-1
    private boolean isSticked = false;
    public boolean getIsSticked() {
        return isSticked;
    }

    public void setStick(boolean stick){
        isSticked = stick;
    }
    public Shape(int x, int y, String path , int type) {
        super(x, y, path);
        this.type = type;
        color = pathSplitter(path);
    }

    private int pathSplitter(String path){
        String[] s = path.split("_");
        return switch (s[1]) {
            case "red" -> 1;
            case "green" -> 2;
            case "blue" -> 3;
            default -> -1;
        };
    }
}
