

import netscape.javascript.JSObject;

import java.awt.*;

public abstract class Shapes implements Shape {

    private Point position;
    private Color color;
    private String ID;

    public String getID(){
        return this.ID;
    }
     public Shapes (){
        this.position=new Point(0,50);
     }
    public void setPosition(java.awt.Point position){
        this.position =position;
    }

    public java.awt.Point getPosition(){return this.position;}

    public void setColor(java.awt.Color color){
        this.color=color;
    }

    public java.awt.Color getColor() {return this.color;}

    public abstract void draw(java.awt.Graphics canvas);
    public abstract boolean contains(Point point);




}
