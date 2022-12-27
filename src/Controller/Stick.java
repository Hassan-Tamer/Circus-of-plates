package Controller;

import Model.Shape;

import java.util.Stack;

public class Stick {
    private Stack<Shape> Collectables = new Stack<>();
    private int y;

    public int intersectionHeight(Shape shape) {
        int type = shape.getType();
        if (Collectables.empty()) {
            if (type == 1) {
                y = -55;
            } else if (type == 2) {
                y = -40;
            }
            } else if (!Collectables.empty() && !shape.getIsSticked()) {
                int peekType = Collectables.peek().getType();
                if (peekType == 1) {
                    y = y - 15;
                } else {
                    if (peekType == 2) {
                        y = y - 35;
                    }
                }
            }

            return y;
    }
    public Stack<Shape> getCollectables(){
        return Collectables;
    }

}
