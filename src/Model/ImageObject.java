package Model;

import eg.edu.alexu.csd.oop.game.GameObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageObject implements GameObject {
    private int x,y;
    private final boolean visible;
    private final BufferedImage[] spriteImage;
    //private String path;
    private Integer [] info= new Integer[2];

    public ImageObject(int x , int y , String path1 , String path2){
        this.x = x;
        this.y = y;
        spriteImage = new BufferedImage[30];
        //this.path = path;
        this.visible = true;
        try {
            for (int i = 0; i< (spriteImage.length/2) ; i++){
            //spriteImage[i] =  ImageIO.read(new File("/Users/omarelshobky/Downloads/Assets/"+path1));
            //spriteImage[i + (spriteImage.length/2)] =  ImageIO.read(new File("/Users/omarelshobky/Downloads/Assets/"+path2));
            spriteImage[i] =  ImageIO.read(new File(path1));
            spriteImage[i + (spriteImage.length/2)] =  ImageIO.read(new File(path2));
            }
        } catch (IOException e) {
            System.out.println("Error Loading Picture ");
        }
    }
    public ImageObject(int x , int y , String path){
        this.x = x;
        this.y = y;
        spriteImage = new BufferedImage[1];
        //this.path = path;
        this.visible = true;
        try {
            //spriteImage[0] =  ImageIO.read(new File("/Users/omarelshobky/Downloads/Assets/"+path));
            spriteImage[0] =  ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("Error Loading Picture" + path);
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
