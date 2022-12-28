package Controller;

import Model.Pie;
import Model.Plate;
import Model.Shape;

import java.util.Stack;

public class Stick {
    private Stack<Shape> Collectables = new Stack<>();
    private int y;

    public int intersectionHeight(Shape shape) {
        if (Collectables.empty()) {
            if (shape instanceof Plate) {
                y = ((Plate) shape).getBottomY();
            } else if (shape instanceof Pie) {
                y = ((Pie) shape).getBottomY();
            }
//            } else if (!Collectables.empty()) {
//                Shape s = Collectables.peek();
//                if (s instanceof Plate) {
//                    y = y - ((Plate) s).getDelta();
//                } else if (s instanceof Pie) {
//                    y = y - ((Pie) s).getDelta();
//                }
            }

            return y;
    }
    public Stack<Shape> getCollectables(){
        return Collectables;
    }

}
