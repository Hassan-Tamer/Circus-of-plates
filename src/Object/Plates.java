package Object;

import java.util.ArrayList;

public class Plates extends ImageObject{
    private  ArrayList<String> shapes  = new ArrayList<String>();

    public Plates(int x, int y, String path) {
        super(x, y, path);
    }


    public ArrayList<String> getShapes(){
        return shapes;
    }


}
