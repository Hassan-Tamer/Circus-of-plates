import View.Circus;

import eg.edu.alexu.csd.oop.game.GameEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args){

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);

        Circus circus = Circus.getInstance(1100,600);
        final GameEngine.GameController gameController =  GameEngine.start("Circus Of Plates", circus,menuBar);

//         newMenuItem.addActionListener(new ActionListener() {
//         @Override public void actionPerformed(ActionEvent e) {
//         		gameController.changeWorld(new eg.edu.alexu.csd.oop.game.sample.world.Space(400, 700));
//         	}
//         });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });

        resumeMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
        }
    }