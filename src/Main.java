import View.Circuis;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            GameEngine.start("Circus Of Plates",
                    new Circuis(1100,600));
        }
    }