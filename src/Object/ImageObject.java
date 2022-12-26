package Object;

import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageObject implements GameObject {
    private int x,y;
    private boolean visible;
    private final BufferedImage[] spriteImage = new BufferedImage[1];
    private String path;


    public ImageObject(int x , int y , String path){
        this.x = x;
        this.y = y;
        this.path = path;
        this.visible = true;
        try {
            spriteImage[0] =  ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error Loading Picture");
        }
    }

    public ImageObject(int x , int y , String path , String path2){
        this.x = x;
        this.y = y;
        this.visible = true;
        try {
            spriteImage[0] =  ImageIO.read(new File(path));
            spriteImage[1] =  ImageIO.read(new File(path2));
        } catch (IOException e) {
            System.out.println("Error Loading Picture");
        }
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return spriteImage[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImage[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImage;
    }
}
