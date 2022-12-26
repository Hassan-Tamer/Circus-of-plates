package Object;

import java.util.ArrayList;

public class Control {
    private ArrayList<ImageObject> collectables= new ArrayList<>();
    private int Difficulty;
    public void AddCollectable(ImageObject image){
        collectables.add(image);
    }
}
