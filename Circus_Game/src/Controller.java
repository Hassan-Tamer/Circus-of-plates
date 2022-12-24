import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller extends JPanel {
    private Graphics canvas;
    private ArrayList<Shapes> records = new ArrayList<>();
    public Controller(Graphics canvas){
        this.canvas=canvas;
    }
    public void addShape(Shapes shape) {
        records.add(shape);

        refresh();
    }


    public void removeShape(Shapes shape) {
        records.remove(shape);
        refresh(this.canvas);
    }


    public Shapes[] getShapes() {
        return records.toArray(new Shapes[0]);
    }
    public int getSizeR(){return this.records.size();}


    public void refresh(Graphics canvas){
        this.refresh();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.fillRect(0,100,600,20);
        records.forEach(shape -> shape.draw(graphics));

    }

    public void refresh() {
        this.repaint();
    }
}

