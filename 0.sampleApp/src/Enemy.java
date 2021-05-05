import java.awt.*;
import lib.game.*;
import lib.game.Rectangle;

public class Enemy extends Actor {
    int hp = 1;
    HpBar hpBar;
	public Enemy(int centerX, int centerY, int width, int height, Rectangle hitArea, String[] tags) {
        super(centerX, centerY, width, height, hitArea, tags);
        hpBar = new HpBar(centerX, top - 5, width, 6, new Rectangle(0, 0, 0, 0), new String[0]);
	}
	public Enemy(int centerX, int centerY, int width, int height, int hp, Rectangle hitArea, String[] tags) {
        super(centerX, centerY, width, height, hitArea, tags);
        this.hp = hp;
        hpBar = new HpBar(centerX, top - 5, width, 6, hp, new Rectangle(0, 0, 0, 0), new String[0]);
	}

    @Override
    public void draw(Graphics g) {
        drawHitArea(g, Color.PINK);
    }
    @Override
    public void collision(Actor other) {
        super.collision(other);
        if (other.hasTag("player-bullet")) {
            damage();
        }
    }
    private void damage() {
        hp--;
        hpBar.hp--;
    }

    @Override
    public void update(Input input) {
        super.update(input);
        if (hp <= 0) {
            destroyed(); 
            hpBar.destroyed();
            GameInfo.setSceneNum(2);
        }
    }
}
