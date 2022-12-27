import View.Circus;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Circus circus = Circus.getInstance(1100,600);
            GameEngine.start("Circus Of Plates", circus);
        }
    }