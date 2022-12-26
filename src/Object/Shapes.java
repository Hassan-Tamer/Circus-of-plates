package Object;

import java.util.ArrayList;

public class Shapes extends ImageObject{
    private int type;

    public Shapes(int x, int y, String path) {
        super(x, y, path);
    }
    public void setType(String Filename) {
        String[] key = Filename.split("_");
        if (key[1].equals("red"))
            this.type = 1;
        else if (key[1].equals("blue"))
            this.type = 2;
        else if (key[1].equals("green"))
            this.type = 3;
        else if (key[1].equals("bomb"))
            this.type = 4;
    }



}
