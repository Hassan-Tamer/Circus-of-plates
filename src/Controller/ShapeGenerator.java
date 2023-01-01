package Controller;

import Model.Bomb;
import Model.Shape;
import Model.Shelf;
import View.Circus;

import java.util.concurrent.ThreadLocalRandom;

public class ShapeGenerator {
    public Shape randomGenerator(Admin a){
        String[] type = {"plate" , "pie"};
        String[] position = {"left" , "right"};
        int count = (int)(Math.random() * type.length);
        int count2 = (int)(Math.random() * type.length);
        ImageObjectFactory newimage=new ImageObjectFactory();
        return newimage.CreatImageObject(type[count],position[count2],a);
    }

    public Bomb randomObstacle(Admin a){
        //Circus circus = Circus.getInstance(1100,600);
        Circus circus = a.getCircus();
        Shelf shelfL = circus.getLeftShelf();
        Shelf shelfR = circus.getRightShelf();

        int x = ThreadLocalRandom.current().nextInt(shelfL.getFallingPosition() + 10, shelfR.getFallingPosition()  - 80);
        return new Bomb(x,0,a);
    }
}
