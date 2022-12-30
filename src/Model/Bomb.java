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
        //int netX = clown.getX() - (b.getX() + b.getWidth());
        int Margin=10;
        int netXRight = clown.getX() + clown.getWidth() - 55 - b.getX();
        int netXLeft = clown.getX()-b.getX();
        int netY = clown.getY() - (b.getY()+ b.getHeight());
        //boolean inRangeX = netX<=0 && netX>=-1*(clown.getWidth());
        boolean inRangeX =(netXLeft<=Margin&&netXLeft>=((-1)*Margin))||(netXRight<=Margin&&netXRight>=((-1)*Margin));
        boolean inRangeY = netY==0;
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
