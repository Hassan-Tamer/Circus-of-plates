package Controller;

import Model.Stick;
import View.Circus;
import eg.edu.alexu.csd.oop.game.GameObject;

public class ShapeHandle {

    private static int Margin = 10;

    public static boolean BombStriked(GameObject b, GameObject clown){
        int netX = clown.getX() - (b.getX());
        int netY = clown.getY() - (b.getY()+ b.getHeight() - 10);
        boolean inRangeX = netX<=b.getWidth() && netX>=-1*(clown.getWidth());
        boolean inRangeY = netY<=0 && netY>=-10;
        return inRangeX && inRangeY;
    }

    public static boolean removeLastThree(Stick stick, Circus c){

        int size = stick.getCollectedShapes().size();
        if(size >= 3) {
            if(stick.getCollectedShapes().get(size-1).getColor() == stick.getCollectedShapes().get(size-2).getColor() && stick.getCollectedShapes().get(size-2).getColor() == stick.getCollectedShapes().get(size-3).getColor())
            {
                c.getControlableObjects().remove(stick.removeCollectedShape(size-1));
                c.getControlableObjects().remove(stick.removeCollectedShape(size-2));
                c.getControlableObjects().remove(stick.removeCollectedShape(size-3));
                c.addPoint();
                return true;
            }
        }
        return false;
    }

    public static boolean leftIntersect(GameObject o , GameObject clown){
        int y = clown.getY();
        int netX = clown.getX() - o.getX();
        int netY = y - (o.getY()+o.getHeight()); // intersect from the top and set it to its y min immediately
        boolean inRangeX = netX<=Margin && netX>=((-1)*Margin);
        boolean inRangeY = Math.abs(netY) < 2;
        return inRangeX && inRangeY;
    }

    public static boolean rightIntersect(GameObject o , GameObject clown){
        int y = clown.getY();
        int netX = clown.getX() + clown.getWidth() - 55 - o.getX();
        int netY = y - (o.getY()+o.getHeight());
        boolean inRangeX = netX<=Margin && netX>=((-1)*Margin);
        boolean inRangeY = Math.abs(netY) < 2;
        return inRangeX && inRangeY;
    }
}
