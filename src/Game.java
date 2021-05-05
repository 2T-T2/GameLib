package lib.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements KeyListener {
    public Game(String title, Dimension size) {
        setTitle(title);
        getContentPane().setPreferredSize(size);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);

        MyPanel panel = new MyPanel(size);

        add(panel, BorderLayout.CENTER);

        pack();
    }

    @Override
    public void keyTyped(KeyEvent e) {
                
    }
    @Override
    public void keyPressed(KeyEvent e) {
        GameInfo.setKeyMap(e.getKeyCode(), true);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        GameInfo.setKeyMap(e.getKeyCode(), false);
    }
}
