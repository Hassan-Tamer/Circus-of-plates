package Model;

import Controller.Admin;
import java.io.IOException;

public class Plate extends Shape{
    public Plate(int x, int y, String path,Admin admin){
        super(x, y, path,admin);
    }

    @Override
    public int Getdelta() {
      return 20;}

    @Override
    public int Getdy() {
        return -5;}
}
