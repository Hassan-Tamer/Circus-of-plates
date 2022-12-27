package Model;

public class Pie extends Shape{

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

    private int BottomY = -40;
    private int delta = 35;
    public Pie(int x, int y, String path) {
        super(x, y, path);
    }
}
