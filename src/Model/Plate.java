package Model;

public class Plate extends Shape{

    public int getBottomY() {
        return BottomY;
    }

    public void setBottomY(int y) {
        this.BottomY = BottomY;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    private int BottomY = -55;
    private int delta = 15;
    public Plate(int x, int y, String path) {
        super(x, y, path);
    }
}
