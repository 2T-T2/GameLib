import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import lib.game.*;

public class StartScene extends Scene {
    StartScene(String name) {
        super(name);
        TitleActor title = new TitleActor((int)GameInfo.getGameWidth(),(int)GameInfo.getGameHeight(),0,0, new Rectangle(0, 0, 0, 0));
        addActor(title);
    }
    @Override
    public void bgDraw(Graphics g) {
        super.bgDraw(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, (int)GameInfo.getGameWidth() , (int)GameInfo.getGameHeight());
    }
    @Override
    public void update(Graphics g, Input input) {
        super.update(g, input);
        if (input.getKey(KeyEvent.VK_ENTER)) {
            GameInfo.nextScene();
        }
    }
}
