import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class view {
    JFrame game = new JFrame();
    private JPanel objectViewer;
    Controller control;

    public view() throws InterruptedException {
        game.setVisible(true);
        game.setContentPane(objectViewer);
        game.setSize(2000, 1000);
        control = new Controller(objectViewer.getGraphics());
        objectViewer.add(control);
        control.refresh();
       Plate p1 = new Plate(Color.BLUE);
       control.addShape(p1);
        TimeUnit.SECONDS.sleep(1);
       for(int i=0;i<12;i++){
           TimeUnit.MILLISECONDS.sleep(90);
           p1.moveHorizontally();
           control.refresh();
       }
       for(int j=0;j<100;j++){
           TimeUnit.MILLISECONDS.sleep(90);
           p1.moveVertically();
           control.refresh();
       }
    }
    public static void main(String[]args) throws InterruptedException {
        new view();

    }
}

