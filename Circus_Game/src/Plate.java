import java.awt.*;
import java.util.ArrayList;

public class Plate extends Shapes{
   private Point p2;
    private Point p3;
    private Point p4;
    private String ID;
    int count= (int) Math.floor(Math.random()*100);
    public Plate(Color color){
        this.p2=new Point(50,50);
        this.p3=new Point(10,100);
        this.p4=new Point(40,100);
        this.ID= "Plate"+count;
        this.setColor(color);
    }

    @Override
    public void draw(Graphics canvas) {
        int x[]=new int[4];
        int y[]=new int[4];
        canvas.setColor(this.getColor());
        x[0]=this.getPosition().x;
        x[1]=this.p2.x;
        x[2]=this.p3.x;
        x[3]=this.p4.x;
        y[0]=this.getPosition().y;
        y[1]=this.p2.y;
        y[2]=this.p3.y;
        y[3]=this.p4.y;

        canvas.fillPolygon(x,y,4);
    }

    @Override
    public boolean contains(Point point) {
        return false;
    }

    public void moveHorizontally() {
      Point newPosition = this.getPosition();
      newPosition.x+=50;
      this.p2.x+=50;
      this.p3.x+=50;
      this.p4.x+=50;
      this.setPosition(newPosition);
    }
    public void moveVertically() {
        Point newPosition = this.getPosition();
        newPosition.y+=10;
        this.p2.y+=10;
        this.p3.y+=10;
        this.p4.y+=10;
        this.setPosition(newPosition);
    }
}
