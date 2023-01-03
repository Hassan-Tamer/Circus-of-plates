package Model;

import Controller.Admin;
import java.io.IOException;

public class Pie extends Shape {
    private Subject sub;
    public Pie(int x, int y, String path,Admin admin){
        super(x, y, path,admin);
    }

    @Override
    public int Getdelta() {
        return 40;
    }

    @Override
    public int Getdy() {
        return 22;}

    @Override
    public void update(int x) {

    }

    @Override
    public void setSubject(Subject sub) {
        this.sub = sub;
    }
}
