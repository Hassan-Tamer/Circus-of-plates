package Model;

public final class Clown extends ImageObject {
    private static Clown INSTANCE;
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
    
}
