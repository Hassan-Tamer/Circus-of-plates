import Controller.Easy;
import View.Circus;

import eg.edu.alexu.csd.oop.game.GameEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenu Diff = new JMenu("Set Difficulty");
        JCheckBoxMenuItem easy = new JCheckBoxMenuItem("Easy");
        JCheckBoxMenuItem med = new JCheckBoxMenuItem("Medium");
        JCheckBoxMenuItem hard = new JCheckBoxMenuItem("Hard");
        Diff.add(easy);
        Diff.add(med);
        Diff.add(hard);
        menu.add(Diff);
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);

        final Circus circus = Circus.getInstance(1100,600);
        final GameEngine.GameController gameController =  GameEngine.start("Circus Of Plates", circus,menuBar);

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
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