package Controller;

import Model.ImageObject;

import java.util.ArrayList;

public class ImageObjectFactory {

    private ArrayList<ImageObject> Collectables = new ArrayList<>();
    public ImageObject CreatImageObject(int index){

        Collectables.add(new ImageObject(0,0,"Assets\\pie_green.png"));
        Collectables.add(new ImageObject(0,0,"Assets\\pie_blue.png"));
        Collectables.add(new ImageObject(0,0,"Assets\\pie_red.png"));
        Collectables.add(new ImageObject(0,0,"Assets\\plate_red.png"));
        Collectables.add(new ImageObject(0,0,"Assets\\plate_blue.png"));
        Collectables.add(new ImageObject(0,0,"Assets\\plate_green.png"));
        ImageObject newObject = Collectables.get(index);
        return newObject;
    }
    public ImageObject CreatBomb(){
        ImageObject Bomb = new ImageObject(0,0,"Assets\\bomb.png");
        return Bomb;
    }

}
