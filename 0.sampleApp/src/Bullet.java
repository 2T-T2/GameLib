import lib.game.*;
import java.awt.*;
import lib.game.Rectangle;

public class Bullet extends Actor {
    Bullet(int centerX, int centerY, int width, int height, Rectangle hitArea, String[] tags) {
        super(centerX, centerY, width, height, hitArea, tags);
        removeOutOfWindow = true;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(left, top, width, height);
    }
    @Override
    public void update(Input input) {
        super.update(input);
        move(0, -5);
    }
    @Override
    public void collision(Actor other) {
        super.collision(other);
        if (other.hasTag("enemy")) {
            destroyed();
        }
    }

    @Override
    public void receiveMessage(GameEvent e) {
        super.receiveMessage(e);
    }
}
