package Model;

import Controller.Admin;
import java.io.IOException;

public class Bomb extends Shape{
public Bomb(int x, int y , String path,Admin admin){
        super(x, y, path,admin);
    }
    public Bomb(int x, int y,Admin admin){
        super(x, y, "Assets\\bomb.png",admin);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }
    @Override
    public void setX(int x) {

    }

    @Override
    public int Getdelta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int Getdy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
