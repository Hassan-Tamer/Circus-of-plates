import Controller.Easy;
import Controller.Hard;
import Controller.Medium;
import View.Circus;

import eg.edu.alexu.csd.oop.game.GameEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args){

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenu Diff = new JMenu("Set Difficulty");
        JMenuItem easy = new JMenuItem("Easy");
        JMenuItem med = new JMenuItem("Medium");
        JMenuItem hard = new JMenuItem("Hard");
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

        //final Circus circus = Circus.getInstance(1100,600);
        final Circus circus = new Circus(1100,600);
        final GameEngine.GameController gameController =  GameEngine.start("Circus Of Plates", circus,menuBar);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circus New = new Easy().changeDifficulty(circus);
                gameController.changeWorld(New);
            }
        });
        med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circus New = new Medium().changeDifficulty(circus);
                gameController.changeWorld(New);
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circus New = new Hard().changeDifficulty(circus);
                gameController.changeWorld(New);
                
            }
        });
        newMenuItem.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
         		gameController.changeWorld(circus.clone());
                        
         	}
 });
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