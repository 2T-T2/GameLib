import java.awt.Color;
import java.awt.Graphics;
import lib.game.*;

public class HpBar extends Actor {
    int hp = 1;
    int maxHp = 1;
    HpBar(int centerX, int centerY, int width, int height, Rectangle hitArea, String[] tags) {
        super(centerX, centerY, width, height, hitArea, tags);
    }
    HpBar(int centerX, int centerY, int width, int height, int hp, Rectangle hitArea, String[] tags) {
        super(centerX, centerY, width, height, hitArea, tags);
        this.hp = hp;
        maxHp = hp;
    }
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.GREEN);
        g.fillRect(left, top, width * hp / maxHp, height);
        g.setColor(Color.GRAY);
        g.drawRect(left, top, width, height);
    }
    @Override
    public void update(Input input) {
        super.update(input);
    }

    @Override
    public void receiveMessage(GameEvent e) {
        super.receiveMessage(e);
    }
}
