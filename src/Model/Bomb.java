package Model;


import eg.edu.alexu.csd.oop.game.GameObject;

public class Bomb extends Shape{
    public Bomb(int x, int y , String path){
        super(x, y, path);
    }

    public Bomb(int x, int y){
        super(x, y, "Assets\\bomb.png");
    }
    public static boolean BombStriked(GameObject b, GameObject clown){
        int netX = clown.getX() - (b.getX() + b.getWidth());
        int netY = clown.getY() - (b.getY()+ b.getHeight() - 10);
        boolean inRangeX = netX<=0 && netX>=-1*(clown.getWidth());
        boolean inRangeY = netY<=0 && netY>=-10;
        return inRangeX && inRangeY;
    }
    @Override
    public void setY(int y) {
        super.setY(y);
    }
    @Override
    public void setX(int x) {

    }

}
