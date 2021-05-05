package lib.game;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel implements Runnable{
    public MyPanel(Dimension size) {
        setSize(size);
        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        GameInfo.getCurrentScene().update(g, GameInfo.getInput() );
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep( 1000 / GameInfo.getfps() );
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
