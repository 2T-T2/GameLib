import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import lib.game.*;

public class Player extends Actor {
    Player(int centerX, int centerY, int width, int height, Rectangle hitArea, String[] tags) {
        super(centerX, centerY, width, height, hitArea, tags);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        int[] xPoint = {left, right, centerX};
        int[] yPoint = {bottom, bottom, top};
        g.fillPolygon(xPoint, yPoint, 3);
        drawHitArea(g, Color.RED);
    }
    @Override
    public void collision(Actor other) {
        super.collision(other);
        if (other.hasTag("enemy")) {
            destroyed();
            GameInfo.setSceneNum(3);
        }
    }

    @Override
    public void update(Input input) {
        super.update(input);
        if(input.getKey(KeyEvent.VK_UP)) move(0, -2);
        if(input.getKey(KeyEvent.VK_DOWN)) move(0, 2);
        if(input.getKey(KeyEvent.VK_LEFT)) move(-2, 0);
        if(input.getKey(KeyEvent.VK_RIGHT)) move(2, 0);
        if(input.getKeyDown(KeyEvent.VK_SPACE)) {
            String[] pBulletTag = {"player-bullet"};
            Bullet bullet = new Bullet(centerX, top, 5, 5, new Rectangle(0, 0, 5, 5), pBulletTag);
            spawnActor(bullet);
        }
    }

    @Override
    public void receiveMessage(GameEvent e) {
        super.receiveMessage(e);
    }
}
