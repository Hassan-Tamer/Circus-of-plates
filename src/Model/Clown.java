package Model;

import java.util.List;

public final class Clown extends ImageObject implements Subject{
    private static Clown INSTANCE;
    private List<Observer> observers;
    private Clown(int x, int y, String path) {
        super(x, y, path);
    }

    public static Clown getInstance(int x, int y, String path) {
        if(INSTANCE == null) {
            INSTANCE = new Clown(x,y,path);
        }
        return INSTANCE;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void register(Observer obj) {
        this.observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        this.observers.remove(obj);
    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public Object getUpdate(Observer obj) {
        return null;
    }
}
