/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Context;
import Controller.Easy;
import Controller.GameState;
import Controller.Hard;
import Controller.Medium;
import Controller.NewGame;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Menu extends JFrame{
    private JButton Easybtn;
    private JButton Hardbtn;
    private JButton Mediumbtn;
    private GameEngine.GameController gamectrl;
    private Circus circus = new Circus(1100, 600);
    private Context context;
    private static GameState state;
    public Menu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        JMenuItem Diff = new JMenuItem("Set Difficulty");
        menu.add(Diff);
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        try {
            //final Image backgroundImage = javax.imageio.ImageIO.read(new File("/Users/omarelshobky/Downloads/Assets/back.png"));
            final Image backgroundImage = javax.imageio.ImageIO.read(new File("Assets\\back.png"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override 
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
                });
            } 
        catch (IOException e) {
                throw new RuntimeException(e);
            }
        Easybtn = new JButton();
        Mediumbtn = new JButton();
        Hardbtn = new JButton();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Easybtn.setBackground(new java.awt.Color(102, 204, 0));
        Easybtn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); 
        Easybtn.setText("Easy");
        Easybtn.setOpaque(true);
        Easybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Easy e = Easy.getInstance();
                context = new Context(e);
                circus=context.executeStrategy(e.changeDifficulty(circus));
                gamectrl =  GameEngine.start("Circus Of Plates", circus,menuBar);
                setVisible(false);
            }
        });
        Mediumbtn.setBackground(new java.awt.Color(204, 204, 0));
        Mediumbtn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); 
        Mediumbtn.setText("Medium");
        Mediumbtn.setOpaque(true);
        Mediumbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medium m = Medium.getInstance();
                context = new Context(m);
                circus=context.executeStrategy(m.changeDifficulty(circus));
                gamectrl =  GameEngine.start("Circus Of Plates", circus,menuBar);
                setVisible(false);
            }
        });

        Hardbtn.setBackground(new java.awt.Color(204, 0, 51));
        Hardbtn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); 
        Hardbtn.setText("Hard");
        Hardbtn.setOpaque(true);
        Hardbtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hard h = Hard.getInstance();
                context = new Context(h);
                circus=context.executeStrategy(h.changeDifficulty(circus));
                gamectrl =  GameEngine.start("Circus Of Plates", circus,menuBar);
                setVisible(false);
            }
        });
        Diff.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
                gamectrl.pause();
                JFrame gameFrame = (JFrame) menuBar.getParent().getParent().getParent();
                gameFrame.setVisible(false);
                setVisible(true);
         	}});
        newMenuItem.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
                 state = new NewGame(circus,gamectrl);   
                 state.gameAction();       
         	}
 });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gamectrl.pause();
            }
        });

        resumeMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gamectrl.resume();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(600,600,600)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Easybtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mediumbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(Hardbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(Easybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Mediumbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Hardbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        setBounds(0, 0, 1100, 600);
        pack();

}
 
}
