package Model;


public class Bomb extends Shape{
    public Bomb(int x, int y , String path){
        super(x, y, path);
    }

    public Bomb(int x, int y){
        super(x, y, "Assets\\bomb.png");
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }
    @Override
    public void setX(int x) {

    }

}
