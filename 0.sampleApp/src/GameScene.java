import lib.game.*;
import lib.game.Rectangle;
import java.awt.*;
public class GameScene extends Scene {
	public GameScene(String t) {
        super(t);
        String[] playerTags = {"player"};
        String[] EnemyTags = {"enemy"};
        Player player = new Player((int)GameInfo.getGameWidth()/2, (int)GameInfo.getGameHeight()*4/5, 20, 30, new Rectangle(0, 8, 14, 14), playerTags);
        Enemy enemy = new Enemy((int)GameInfo.getGameWidth()/2, (int)GameInfo.getGameHeight()*1/5, 30, 20, 10, new Rectangle(0, 0, 20, 20), EnemyTags);
        addActor(player);
        addActor(enemy);
        addActor(enemy.hpBar);
	}
    @Override
    public void bgDraw(Graphics g) {
        super.bgDraw(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int)GameInfo.getGameWidth() , (int)GameInfo.getGameHeight());
    }

    @Override
    public void receiveMessage(GameEvent e) {
        super.receiveMessage(e);
    }
}
