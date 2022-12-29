package Model;

public class Shelf extends ImageObject{

    public int getFallingPosition() {
        return fallingPosition;
    }

    private final int fallingPosition;

    public Shelf(int x, int y, String path , int fallingPosition) {
        super(x, y, path);
        this.fallingPosition = fallingPosition;
    }
}
