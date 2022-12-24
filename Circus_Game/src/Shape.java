public interface Shape {


    public void setPosition(java.awt.Point position);
    public java.awt.Point getPosition();
    public String getID();
    public void setColor(java.awt.Color color);
    public java.awt.Color getColor();

    public void draw(java.awt.Graphics canvas);

}