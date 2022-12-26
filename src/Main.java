import World.Circuis;
import eg.edu.alexu.csd.oop.game.GameEngine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            GameEngine.start("Circus Of Plates",
                    new Circuis(1100,600));
        }
    }