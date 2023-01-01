package View;

import javax.swing.*;

public class Menu {
    public static JMenuBar initMenu(){
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
        return menuBar;
    }
}
